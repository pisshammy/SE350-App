import java.util.List;

public class HighScoreCalc implements StatCalc {
    @Override
    public double calculate(List<ScenarioStats> data) {
        if (data == null || data.isEmpty()) {
            return 0.0;
        }

        double maxScore = 0.0;
        for (ScenarioStats stat : data) {
            if (stat.getScore() > maxScore) {
                maxScore = stat.getScore();
            }
        }
        return maxScore;
    }
}