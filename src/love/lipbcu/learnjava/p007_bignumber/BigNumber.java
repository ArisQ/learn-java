package love.lipbcu.learnjava.p007_bignumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumber {
    public static void main(String[] args) {
        BigInteger a = BigInteger.TEN;
        System.out.println(a);

        a = BigInteger.valueOf(100);
        System.out.println(a);

        BigInteger b = BigInteger.valueOf(300);
        System.out.println(b);

        BigInteger c = a.add(b);
        System.out.println(c);

        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b));
        System.out.println(a.compareTo(b));

        BigDecimal fa = BigDecimal.valueOf(1234567890);
        BigDecimal fb = BigDecimal.valueOf(7654, -5);
        System.out.println(fa);
        System.out.println(fb);
        System.out.println(fa.add(fb));
        System.out.println(fa.subtract(fb));
        System.out.println(fa.multiply(fb));
        System.out.println(fa.divide(fb, RoundingMode.HALF_UP));
        System.out.println(fa.compareTo(fb));
    }
}
