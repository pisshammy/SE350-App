public class DefaultStatsBuilder implements IStatsBuilder {
    private ScenarioStats stats;

    public DefaultStatsBuilder() {
        this.stats = new ScenarioStats();
    }

    @Override
    public void buildScenarioName(String name) {
        stats.setScenarioName(name);
    }

    @Override
    public void buildScore(double score) {
        stats.setScore(score);
    }

    @Override
    public void buildHitCount(int hits) {
        stats.setHitCount(hits);
    }

    @Override
    public void buildMissCount(int misses) {
        stats.setMissCount(misses);
    }

    @Override
    public ScenarioStats getResult() {
        ScenarioStats completedProduct = this.stats;
        this.stats = new ScenarioStats();
        return completedProduct;
    }
}