public class HighScoreCalcFactory implements StatCalcFactory {
    @Override
    public StatCalc createCalc() {
        return new HighScoreCalc();
    }
}