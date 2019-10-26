package love.lipbcu.learnjava.p013_autoboxing;

import java.util.ArrayList;

public class AutoBoxing {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(Integer.valueOf(4));
        for (int i : list)
            System.out.println(i);

        Byte b = 3;
        System.out.println(b);
        b++;
        System.out.println(b);

        Integer n = null;
        try {
            System.out.println(n * 2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println(Integer.parseInt("1234"));
    }
}
