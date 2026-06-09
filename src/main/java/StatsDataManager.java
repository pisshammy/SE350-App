import java.util.ArrayList;
import java.util.List;

public class StatsDataManager implements Subject {
    private final List<StatsObserver> observers = new ArrayList<>();
    private List<ScenarioStats> currentStatsList;

    @Override
    public void attach(StatsObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(StatsObserver observer) {
        observers.remove(observer);
    }

    @Override
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