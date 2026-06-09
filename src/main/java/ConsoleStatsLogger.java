public class ConsoleStatsLogger implements StatsObserver {
    private StatsDataManager subject;
    private StatCalc avgCalculator;
    private StatCalc scoreCalculator;
    private boolean isFirstUpdate = true;

    public ConsoleStatsLogger(StatsDataManager subject, StatCalc avgCalculator, StatCalc scoreCalculator) {
        this.subject = subject;
        this.avgCalculator = avgCalculator;
        this.scoreCalculator = scoreCalculator;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if (isFirstUpdate) {
            isFirstUpdate = false;
            return;
        }

        System.out.println("New Run Count: " + subject.getFreshData().size());
        System.out.println("  Updated Average Accuracy: " + avgCalculator.calculate(subject.getFreshData()));
        System.out.println("  Updated High Score: " + scoreCalculator.calculate(subject.getFreshData()));
    }
}