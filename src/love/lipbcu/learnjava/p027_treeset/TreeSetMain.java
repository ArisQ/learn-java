package love.lipbcu.learnjava.p027_treeset;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        SortedSet<String> parts = new TreeSet<String>() {{
            add("Toaster");
            add("Widget");
            add("Modem");
        }};
        System.out.println(parts);

        NavigableSet<String> sorted = new TreeSet<>(
                Comparator.comparing(String::hashCode)
        );
        sorted.addAll(parts);
        System.out.println(sorted);
    }
}
