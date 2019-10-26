package love.lipbcu.learnjava.p012_arraylist;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee());
        staff.add(new Employee("Harry", 2000, 1999, 9, 9));
        staff.add(new Employee("Tony", 1000, 2999, 1, 1));

        System.out.println(staff.size());
        for (Employee e : staff)
            System.out.println(e);

        staff.ensureCapacity(10);
        System.out.println(staff.size());

        Employee harry = new Employee("Harry", 3000, 1899, 2, 7);
        staff.set(1, harry);
        System.out.println(staff.size());
        for (Employee e : staff)
            System.out.println(e);
        harry.raiseSalary(50);
        System.out.println("harry: " + harry);
        for (Employee e : staff)
            System.out.println(e);
        System.out.println("staff[2]: " + staff.get(2));

        Employee tom = new Employee("Tom", 500, 2008, 8, 8);
        System.out.println("tom: " + tom);
        staff.add(1, tom);
        for (Employee e : staff)
            System.out.println(e);
    }
}
