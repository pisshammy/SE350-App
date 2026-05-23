import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing KovaaK's Aim Trainer Stat Tracker...");
        
        String testFile = "src\\csvExamples\\Ascended Tracking v3 - Challenge - 2026.05.14-22.25.01 Stats.csv";
        
        System.out.println("Testing CSV reading with file: " + testFile);
        //proxy pattern
        DataReader reader = new CachedCsvReaderProxy();
        //read from disk and cache results
        List<ScenarioStats> stats = reader.readData(testFile);
        //factory pattern
        StatCalcFactory avgFactory = new AverageCalcFactory();
        StatCalcFactory scoreFactory = new HighScoreCalcFactory();
        
        //strategy pattern
        StatAnalyzer analyzer = new StatAnalyzer(avgFactory.createCalc());
        System.out.println("Average Accuracy: " + analyzer.execute(stats));
        analyzer.setStrategy(scoreFactory.createCalc());
        System.out.println("High Score: " + analyzer.execute(stats));
        //proxy pattern should return cached data without re-reading the file
        reader.readData(testFile);
    }
}
