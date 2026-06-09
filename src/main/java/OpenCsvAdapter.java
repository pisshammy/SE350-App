import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class OpenCsvAdapter implements DataReader {

    public final String defaultCsvPath = pathToCsv();
    private CSVReader adapteeReader;
    private StatsDirector director;

    public OpenCsvAdapter() {
        IStatsBuilder builder = new DefaultStatsBuilder();
        this.director = new StatsDirector(builder);
    }

    public OpenCsvAdapter(StatsDirector director) {
        this.director = director;
    }

    public static String pathToCsv() {
        String path = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\FPSAimTrainer\\FPSAimTrainer\\stats";
        try {
            if (new File(path).exists()) {
                return path;
            } else {
                return "./csvExamples/";
            }
        } catch (Exception e) {
            System.out.println("Error determining CSV path: " + e.getMessage());
            return "./csvExamples/";
        }
    }

    @Override
    public List<ScenarioStats> readData(String filePath) {
        List<ScenarioStats> resultList = new ArrayList<>();
        String tempScenarioName = null;
        double tempScore = 0.0;
        int tempHitCount = 0;
        int tempMissCount = 0;

        try {
            this.adapteeReader = new CSVReader(new FileReader(filePath));
            String[] line;

            while ((line = this.adapteeReader.readNext()) != null) {
                if (line.length < 2 || line[0].trim().isEmpty()) {
                    continue;
                }
                
                String key = line[0].trim();
                String value = line[1].trim();

                switch (key) {
                    case "Scenario:":
                        tempScenarioName = value;
                        break;
                    case "Score:":
                        tempScore = Double.parseDouble(value);
                        break;
                    case "Hit Count:":
                        tempHitCount = Integer.parseInt(value);
                        break;
                    case "Miss Count:":
                        tempMissCount = Integer.parseInt(value);
                        break;
                }
            }
            this.adapteeReader.close();

            if (tempScenarioName != null) {
                ScenarioStats stats = director.construct(tempScenarioName, tempScore, tempHitCount, tempMissCount);
                resultList.add(stats);
            }
            return resultList;

        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return resultList;
        }
    }

    public void checkLogDirectory(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("Warning: CSV directory not found at " + path);
        } else {
            System.out.println("CSV directory located successfully.");
        }
    }

    public static void main(String[] args) {
        OpenCsvAdapter adapter = new OpenCsvAdapter();
        String pathToCheck = args.length > 0 ? args[0] : adapter.defaultCsvPath;
        adapter.checkLogDirectory(pathToCheck);
    }
}