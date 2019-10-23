package love.lipbcu.learnjava.p003_operators;

enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};

public class Operators {
    public static void main(String[] args) {
        System.out.println(5 + 3);
        System.out.println(5 - 3);
        System.out.println(5 * 3);
        System.out.println(5 / 3);
        System.out.println(5 % 3);

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println(5.0 / 0);
        System.out.println(0.0 / 0);

        // Math类
        System.out.println(Math.sqrt(5));
        System.out.println(Math.pow(4, 3));
        System.out.println(Math.floorMod(4, 3));
        System.out.println(Math.floorMod(-4, 3));

        System.out.println(Math.sin(Math.PI / 3));
        System.out.println(Math.cos(Math.PI / 3));
        System.out.println(Math.tan(Math.PI / 3));
        System.out.println(Math.atan(-1));
        System.out.println(Math.atan2(-1, 1));
        System.out.println(Math.atan2(1, -1));

        System.out.println(Math.exp(1));
        System.out.println(Math.exp(2));
        System.out.println(Math.log(1));
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(1));
        System.out.println(Math.log10(1000));

        System.out.println(Math.PI);
        System.out.println(Math.E);

        // 强制类型转换
        double x = Math.PI;
        int nx = (int) x;
        System.out.println(nx);
        System.out.println(Math.round(3.5));

        // 结合赋值和运算符
        x += 4;
        System.out.println(x);

        // 自增自减
        System.out.println(nx--);
        System.out.println(nx++);
        System.out.println(--nx);
        System.out.println(++nx);

        // 关系运算符
        long y = Math.round(Math.random() * 10);
        System.out.println(y);
        System.out.println(y == 2);
        System.out.println(y > 2 ? y : 2);

        // 位运算符
        System.out.println(y | 0x02);
        System.out.println(y << 3);
        System.out.println(y >> 3);
        System.out.println(y >>> 3);
        System.out.println(-1000 >> 3);
        System.out.println(-1000 >>> 3);

        // 枚举
        // enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
        Size s = Size.MEDIUM;
        System.out.println(s);
        s = null;
        System.out.println(s);
    }
}
