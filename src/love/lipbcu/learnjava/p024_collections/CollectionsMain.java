package love.lipbcu.learnjava.p024_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionsMain {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("str1");
            add("str2");
            add("str3");
        }};
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        for (String element : strings) {
            System.out.println(element);
        }

        System.out.println(strings);
        iterator = strings.iterator();
        try {
            iterator.remove();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(strings);

        // 泛型实用方法
        System.out.println(strings.size());
        System.out.println(strings.isEmpty());
        System.out.println(strings.contains("str1"));
        System.out.println(strings.contains("str2"));
        System.out.println(strings.containsAll(new ArrayList<String>() {{
            add("str2");
            add("str3");
        }}));
        strings.addAll(new ArrayList<String>() {{
            add("str4");
            add("str5");
            add("str6");
            add("str7");
        }});
        System.out.println(strings);

        strings.remove("str4");
        System.out.println(strings);
        strings.removeAll(new ArrayList<String>() {{
            add("str2");
            add("str3");
        }});
        System.out.println(strings);

        System.out.println(strings.retainAll(new ArrayList<String>() {{
            add("str6");
            add("str7");
            add("str8");
        }}));
        System.out.println(strings);

        System.out.println(Arrays.toString(strings.toArray()));
        String[] arrayToFill = new String[10];
        arrayToFill[0] = "str9";
        System.out.println(Arrays.toString(strings.toArray(arrayToFill)));
        System.out.println(Arrays.toString(strings.toArray(new String[4])));

        strings.clear();
        System.out.println(strings);
    }
}
