import java.util.List;

public class CachedCsvReaderProxy implements DataReader {
    private OpenCsvAdapter realAdapter;
    private List<ScenarioStats> cachedData;
    private String cachedFilePath;

    @Override
    public List<ScenarioStats> readData(String filePath) {
    
        if (realAdapter == null) {
            realAdapter = new OpenCsvAdapter();
        }

        if (filePath.equals(cachedFilePath) && cachedData != null) {
            System.out.println("Proxy: Returning cached data for " + filePath);
            return cachedData;
        }

        System.out.println("Proxy: Parsing CSV file from disk...");
        cachedData = realAdapter.readData(filePath);
        cachedFilePath = filePath;
        
        return cachedData;
    }
}