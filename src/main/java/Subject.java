public interface Subject {
    void attach(StatsObserver observer);
    void detach(StatsObserver observer);
    void notifyObservers();
}