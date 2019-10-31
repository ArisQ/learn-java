package love.lipbcu.learnjava.p023_genericclass;

import love.lipbcu.learnjava.p008_array.Array;

import java.time.LocalDate;
import java.util.Arrays;

public class GenericClass {
    public static void main(String[] args) {
        // 泛型类
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        System.out.println("words: " + Arrays.toString(words));
        Pair<String> mm = minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        // 泛型方法
        Integer[] integers = {1, 2, 3, 4, 5};
        System.out.println("integers: " + Arrays.toString(integers));
        System.out.println("str middle = " + getMiddle(words));
        System.out.println("int middle = " + getMiddle(integers));

        // 类型变量的限定 && 超类型限定
        System.out.println("str min = " + min(words));
        System.out.println("int min = " + min(integers));
        LocalDate[] dates = new LocalDate[]{
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(2),
        };
        System.out.println("dates: " + Arrays.toString(dates));
        System.out.println("date min = " + min(dates));

        // 不能创建参数化类型的数组
        // Pair<String>[] pairString = new Pair<String>[10];
        Pair<String>[] pairString = (Pair<String>[]) new Pair<?>[10];
        // 不能实例化类型变量，查看实现部分
        newGenericInstance("xyz");
        // 泛型类型在静态上下文无效，见Singleton
    }

    public static Pair<String> minmax(String[] words) {
        if (words == null || words.length == 0)
            return null;
        String min = words[0];
        String max = words[0];
        for (int i = 1; i < words.length; i++) {
            if (min.compareTo(words[i]) > 0)
                min = words[i];
            if (max.compareTo(words[i]) < 0)
                max = words[i];
        }
        return new Pair<>(min, max);
    }

    // @SuppressWarnings("unchecked")
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    // public static <T extends Comparable<? super T>> T min(T[] a) {
    public static <T extends Comparable<T>> T min(T[] a) {
        if (a == null || a.length == 0)
            return null;
        T min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
        }
        return min;
    }

    public static <T> void newGenericInstance(T a) {
        // T b = new T();
    }
}
