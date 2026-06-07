import java.util.ArrayList;
import java.util.List;

public class StatsDataManager {
    private final List<StatsObserver> observers = new ArrayList<>();
    private List<ScenarioStats> currentStatsList;

    public void attach(StatsObserver observer) {
        observers.add(observer);
    }

    public void detach(StatsObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StatsObserver observer : observers) {
            observer.update();
        }
    }

    public List<ScenarioStats> getFreshData() {
        return this.currentStatsList;
    }

    public void setFreshData(List<ScenarioStats> newData) {
        this.currentStatsList = newData;
        notifyObservers(); 
    }
}