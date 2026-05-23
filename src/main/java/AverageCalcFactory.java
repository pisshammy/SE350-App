public class AverageCalcFactory implements StatCalcFactory {
    @Override
    public StatCalc createCalc() {
        return new AverageAccuracyCalc();
    }
}