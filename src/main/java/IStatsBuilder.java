public interface IStatsBuilder {
    void buildScenarioName(String name);
    void buildScore(double score);
    void buildHitCount(int hits);
    void buildMissCount(int misses);
    ScenarioStats getResult();
}