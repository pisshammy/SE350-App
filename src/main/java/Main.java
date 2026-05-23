import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing KovaaK's Aim Trainer Stat Tracker...");
        OpenCsvAdapter adapter = new OpenCsvAdapter();

        String testFile = "src\\csvExamples\\Ascended Tracking v3 - Challenge - 2026.05.14-22.25.01 Stats.csv";
        System.out.println("Testing CSV reading with file: " + testFile);
        List<ScenarioStats> stats = adapter.readData(testFile);

        StatAnalyzer analyzer = new StatAnalyzer(new AverageAccuracyCalc());
        double average = analyzer.execute(stats);
        System.out.println("Average Accuracy: " + average);
    }
}
