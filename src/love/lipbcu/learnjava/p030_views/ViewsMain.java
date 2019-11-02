package love.lipbcu.learnjava.p030_views;


import java.util.*;

public class ViewsMain {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("Amy", "Bob", "Carl"));
        System.out.println(Collections.nCopies(10, "Default"));
        System.out.println(Collections.emptySet());
        System.out.println(Collections.singleton(1));

        List<String> names = new LinkedList<>(Arrays.asList("Amy", "Bob", "Carl", "David", "Edward"));
        List<String> group = names.subList(1, 3);
        System.out.println(group);
        group.clear();
        System.out.println(names);

        System.out.println("Set subrange");
        SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList("Amy", "Bob", "Carl", "David", "Edward"));
        System.out.println(sortedSet.headSet("David"));
        System.out.println(sortedSet.subSet("Bob", "Edward"));
        System.out.println(sortedSet.tailSet("David"));

        System.out.println("Unmodified collection");
        System.out.println(Collections.unmodifiableSet(sortedSet));
        System.out.println(Collections.synchronizedSet(sortedSet));
        System.out.println(Collections.checkedSet(sortedSet, String.class));
    }
}
