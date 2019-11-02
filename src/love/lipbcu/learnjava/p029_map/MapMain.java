package love.lipbcu.learnjava.p029_map;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;


public class MapMain {
    private enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2456", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));
        System.out.println(staff);
        for (String key : staff.keySet())
            System.out.println(key);

        staff.put("456-62-5527", new Employee("Francesca Miller"));
        System.out.println(staff.get("157-62-7935"));
        staff.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        Map<String, Integer> counts = new HashMap<String, Integer>() {{
            put("Amy", 1);
            put("Bob", 2);
        }};
        System.out.println(counts);

        // 更新映射项
        counts.put("Amy", counts.get("Amy") + 1);
        System.out.println(counts);
        try {
            counts.put("Carl", counts.get("Carl") + 1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        counts.put("Carl", counts.getOrDefault("Carl", 0) + 1);
        System.out.println(counts);
        counts.putIfAbsent("Carl", 10);
        counts.putIfAbsent("Harry", 10);
        System.out.println(counts);
        counts.merge("Harry", 10, Integer::sum);
        counts.merge("Peter", 10, Integer::sum);
        System.out.println(counts);

        // view
        System.out.println("views:");
        System.out.println(counts.keySet());
        System.out.println(counts.values());
        System.out.println(counts.entrySet());

        // 链接散列集与映射
        Map<String, Employee> linkedStaff = new LinkedHashMap<>();
        linkedStaff.put("144-25-5464", new Employee("Amy Lee"));
        linkedStaff.put("567-24-2456", new Employee("Harry Hacker"));
        linkedStaff.put("157-62-7935", new Employee("Gary Cooper"));
        linkedStaff.put("456-62-5527", new Employee("Francesca Cruz"));
        for (String key : linkedStaff.keySet())
            System.out.println(key);

        Set<Integer> intSet = new HashSet<Integer>() {{
            add(3);
            add(5);
            add(4);
            add(0);
            add(1);
        }};
        Set<Integer> linkedIntSet = new LinkedHashSet<Integer>() {{
            add(3);
            add(5);
            add(4);
            add(0);
            add(1);
        }};
        System.out.println(intSet);
        System.out.println(linkedIntSet);

        // 枚举集与映射
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        EnumSet<Weekday> weekend = EnumSet.of(Weekday.SATURDAY, Weekday.SUNDAY);
        System.out.println(always);
        System.out.println(never);
        System.out.println(workday);
        System.out.println(weekend);

        // 标识散列映射
        System.out.println(System.identityHashCode(Integer.valueOf(1)));
        System.out.println(System.identityHashCode(Integer.valueOf(2)));
        System.out.println(Integer.valueOf(1).hashCode());
        System.out.println(Integer.valueOf(2).hashCode());
    }
}
