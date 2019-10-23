package love.lipbcu.learnjava.p001_datatype;

public class DataType {
    public static void main(String[] args) {
        // 整型
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        // 浮点
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MIN_NORMAL);
        System.out.println(Float.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MIN_NORMAL);
        System.out.println(Double.MAX_VALUE);

        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);

        System.out.println(0x1.0p-3);
        System.out.println(Double.NaN == Double.NaN); // intended
        System.out.println(Double.isNaN(Double.NaN));

        // Char
        System.out.println('A');
        System.out.println('\u2122');
        System.out.println('\u03C0');
        System.out.println("\u0022+\u0022"); // = ""

        System.out.println(false);
        System.out.println(true);
    }
}
