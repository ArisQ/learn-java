package love.lipbcu.learnjava.p021_assertion;

/*
 need to run with -enableassertions or -ea
 */
public class AssertionMain {
    public static void main(String[] args) {
        System.out.println(assertTestSqrt(0));
        System.out.println(assertTestSqrt(101));
        try {
            System.out.println(assertTestSqrt(-101));
        } catch (Error e) {
            System.out.println("Assertion Error:");
            e.printStackTrace();
        }
    }

    public static int assertTestSqrt(int x) {
        assert x >= 0;
        int a = 0, b = x;
        //a<=sqrt(x)    b>=sqrt(x)
        while (a + 1 < b) {
            int m = (a + b) / 2;
            int mSquare = m * m;
            if (mSquare == x)
                return m;
            else if (mSquare < x)
                a = m;
            else
                b = m;
        }
        return a;
    }
}
