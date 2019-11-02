package love.lipbcu.learnjava.p025_linkedlist;

import java.util.*;

public class LinkedListMain {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        System.out.println(staff);
        Iterator<String> iterator = staff.iterator();
        String first = iterator.next();
        String second = iterator.next();
        System.out.printf("%s, %s\n", first, second);
        iterator.remove();
        try {
            iterator.remove();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println(staff);

        ListIterator<String> listIterator = staff.listIterator();
        listIterator.add("Juliet");
        System.out.println(staff);
        listIterator = staff.listIterator(staff.size());
        listIterator.previous();
        listIterator.remove();
        System.out.println(staff);

        try {
            iterator.next(); // already modified by other iterator (listIterator)
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
