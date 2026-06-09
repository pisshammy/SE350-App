import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {
    
    // Scans the target directory and returns files matching the scenario prefix
    public static List<File> getScenarioFiles(String directoryPath, String scenarioPrefix) {
        List<File> matchedFiles = new ArrayList<>();
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                // Ensure it's a file, matches the target scenario, and is a CSV
                if (file.isFile() && file.getName().startsWith(scenarioPrefix) && file.getName().endsWith(".csv")) {
                    matchedFiles.add(file);
                }
            }
        } else {
            System.out.println("Error: Could not read directory " + directoryPath);
        }
        
        return matchedFiles;
    }
}