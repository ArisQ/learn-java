package love.lipbcu.learnjava.p016_reflective;

import love.lipbcu.learnjava.p008_array.Array;

import java.util.Arrays;
import java.util.Random;

public class Reflective {
    public static void main(String[] args) {
        System.out.println(new Random().getClass());
        try {
            System.out.println(Class.forName("java.util.Random"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Random.class);
        System.out.println(int.class);
        System.out.println(int[].class);
        System.out.println(double[].class);
        System.out.println(Double[].class);

        try {
            System.out.println(Random.class.newInstance());
            System.out.println(int.class.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Class cl = Random.class;
        System.out.println(Arrays.toString(cl.getFields()));
        System.out.println(Arrays.toString(cl.getDeclaredFields()));
        System.out.println(Arrays.toString(cl.getMethods()));
        System.out.println(Arrays.toString(cl.getDeclaredMethods()));
        System.out.println(Arrays.toString(cl.getConstructors()));
        System.out.println(Arrays.toString(cl.getDeclaredConstructors()));
    }
}
