package love.lipbcu.learnjava.p008_array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++)
            a[i] = i % 10;
        for (int e : a)
            System.out.print(e);
        System.out.println();

        a = new int[]{2, 3, 5, 7, 11, 13};
        for (int e : a)
            System.out.print(e);
        System.out.println();
        System.out.println();

        int[] b = a;
        for (int e : b)
            System.out.print(e);
        System.out.println();
        b[1] = 6;
        for (int e : a)
            System.out.print(e);
        System.out.println();
        for (int e : b)
            System.out.print(e);
        System.out.println();
        System.out.println();

        int[] c = Arrays.copyOf(a, a.length);
        c[2] = 15;
        for (int e : a)
            System.out.print(e);
        System.out.println();
        for (int e : c)
            System.out.print(e);
        System.out.println();
        System.out.println();

        for (String arg : args)
            System.out.println(arg);

        int n = 100;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = (int) (Math.random() * n * 2);
        for (int e : numbers)
            System.out.print(e + " ");
        System.out.println();
        Arrays.sort(numbers);
        for (int e : numbers)
            System.out.print(e + " ");
        System.out.println();
        System.out.println(Arrays.binarySearch(numbers, numbers[4]));

        int[][] balances = {
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };
        for (int[] r : balances) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        int[][] theYangHuiTriangle = new int[10][];
        for (int i = 0; i < theYangHuiTriangle.length; i++) {
            theYangHuiTriangle[i] = new int[i + 1];
            theYangHuiTriangle[i][0] = 1;
            theYangHuiTriangle[i][i] = 1;
            for (int j = 1; j < i; j++)
                theYangHuiTriangle[i][j] = theYangHuiTriangle[i - 1][j - 1] + theYangHuiTriangle[i - 1][j];
        }
        for (int[] r : theYangHuiTriangle) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
