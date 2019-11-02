package love.lipbcu.learnjava.p031_algorithms;

import java.util.*;

public class AlgorithmsMain {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>(Arrays.asList("Amy", "Bob", "Carl", "David", "Edward"));
        System.out.println(staff);

        staff.sort(Comparator.reverseOrder());
        System.out.println(staff);
        Collections.sort(staff);
        System.out.println(staff);

        System.out.println(Collections.binarySearch(staff, "David"));

        List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 1));
        System.out.println(numbers);
        System.out.println(Collections.replaceAll(numbers, 2, 5));
        System.out.println(numbers);
        System.out.println(Collections.min(numbers));
        System.out.println(Collections.max(numbers));
        numbers.replaceAll(e -> e + 1);
        System.out.println(numbers);
        numbers.removeAll(Arrays.asList(2, 6));
        System.out.println(numbers);
        numbers.retainAll(Collections.singleton(4));
        System.out.println(numbers);

        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
