import java.util.List;

// Context Class
public class StatAnalyzer {
    private StatCalc strategy;

    public StatAnalyzer(StatCalc strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(StatCalc strategy) {
        this.strategy = strategy;
    }

    public double execute(List<ScenarioStats> data) {
        return this.strategy.calculate(data);
    }
}