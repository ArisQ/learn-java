package love.lipbcu.learnjava.p019_innerclass;

public class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return super.toString() + "[" + first + ", " + second + "]";
        }
    }

    public static Pair minmax(double[] values) {
        assert values.length > 0;
        double min = values[0];
        double max = values[0];
        for (double v : values) {
            if (v < min)
                min = v;
            if (v > max)
                max = v;
        }
        return new Pair(min, max);
    }

}
