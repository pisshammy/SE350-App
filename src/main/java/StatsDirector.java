public class StatsDirector {
    private IStatsBuilder builder;

    public StatsDirector(IStatsBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(IStatsBuilder builder) {
        this.builder = builder;
    }

    public ScenarioStats construct(String name, double score, int hits, int misses) {
        builder.buildScenarioName(name);
        builder.buildScore(score);
        builder.buildHitCount(hits);
        builder.buildMissCount(misses);
        return builder.getResult();
    }
}