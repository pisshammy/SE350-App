public class ConsoleStatsLogger implements StatsObserver {
    private StatsDataManager subject;

    public ConsoleStatsLogger(StatsDataManager subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println("Data updated. New record count: " + subject.getFreshData().size());
    }
}