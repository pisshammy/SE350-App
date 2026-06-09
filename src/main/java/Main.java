
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing KovaaK's Aim Trainer Stat Tracker...");

        String targetScenario = "VT 1w3ts Intermediate S5";
        String statsDirectory = OpenCsvAdapter.pathToCsv(); // builder pattern inside adapter pattern
        System.out.println("Scanning directory: " + statsDirectory);

        List<File> targetFiles = DirectoryScanner.getScenarioFiles(statsDirectory, targetScenario);
        System.out.println("Found " + targetFiles.size() + " run(s).");

        //proxy and adapter patterns
        DataReader reader = new CachedCsvReaderProxy();
        List<ScenarioStats> masterStatList = new ArrayList<>();
        for (File file : targetFiles) {
            List<ScenarioStats> fileData = reader.readData(file.getAbsolutePath());
            masterStatList.addAll(fileData);
        }

        //observer pattern
        StatsDataManager dataManager = new StatsDataManager();

        //factory pattern
        StatCalcFactory avgFactory = new AverageCalcFactory();
        StatCalcFactory scoreFactory = new HighScoreCalcFactory();
        StatCalc avgCalc = avgFactory.createCalc();
        StatCalc scoreCalc = scoreFactory.createCalc();

        //strategy pattern
        StatAnalyzer analyzer = new StatAnalyzer(avgCalc);
        System.out.println("Average Accuracy: " + analyzer.execute(masterStatList));
        analyzer.setStrategy(scoreCalc);
        System.out.println("High Score: " + analyzer.execute(masterStatList));

        //observer pattern - attach logger after initial analysis
        new ConsoleStatsLogger(dataManager, avgCalc, scoreCalc);
        dataManager.setFreshData(masterStatList);

        //simulate new runs every 2 seconds
        System.out.println("\nSimulating incoming runs...");
        double currentHighScore = (double) analyzer.execute(masterStatList);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                ScenarioStats fakeRun = new ScenarioStats();
                fakeRun.setScenarioName(targetScenario);
                currentHighScore += (5 + Math.random() * 95);
                fakeRun.setScore(currentHighScore);
                fakeRun.setHitCount(100 + i);
                fakeRun.setMissCount(10 - i);

                masterStatList.add(fakeRun);
                dataManager.setFreshData(masterStatList);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
