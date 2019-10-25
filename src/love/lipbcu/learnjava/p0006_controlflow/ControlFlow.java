package love.lipbcu.learnjava.p0006_controlflow;

public class ControlFlow {
    public static void main(String[] args) {
        int v = (int) Math.round(Math.random() * 10);

        System.out.println(v);

        if (v < 3)
            System.out.println("Less than 3");
        else if (v < 6)
            System.out.println("Less than 6");
        else
            System.out.println("Great or equal to 6");

        int vi = v;
        while (vi > 0) {
            System.out.println(vi);
            vi--;
        }

        do {
            System.out.println(vi);
            vi++;
        } while (vi < v);

        for (int i = 0; i < v; ++i)
            System.out.println(i);

        int c10v = 1;
        for (int i = 0; i < v; ++i) {
            c10v *= 10 - i;
            c10v /= i + 1;
        }
        System.out.printf("C_10^%d=%d\n", v, c10v);

        switch (v) {
            case 2:
                System.out.printf("%d is even prime number.", v);
                break;
            case 3:
            case 5:
            case 7:
                System.out.printf("%d is odd prime number.", v);
                break;
            default:
                System.out.printf("%d is not prime number.", v);
                break;
        }

        switch ('a' + v) {
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            default:
                System.out.println("Not a b c");
                break;
        }

        int i = 0, j = 0;
        outer:
        for (i = 0; i <= v; ++i)
            for (j = 0; j <= i; ++j)
                if (i + j == v)
                    break outer;
        System.out.printf("%d + %d = %d %n", i, j, v);

        for (i = 0; i <= v; ++i) {
            if (i + i != v)
                continue;
            System.out.printf("%d + %<d = %d %n", i, v);
        }
    }
}
