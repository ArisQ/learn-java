package love.lipbcu.learnjava.p009_class;

import java.time.LocalDate;
import java.util.Date;

// 静态导入
import static java.lang.Math.*;

public class Class {
    public static void main(String[] args) {
        System.out.println(new Date());
        Date birthday = new Date();
        String s = birthday.toString();

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getMonth());
        localDate = localDate.plusDays(1000);
        System.out.println(localDate);

        printMonthCalendarOfDate(LocalDate.now());
        printMonthCalendarOfDate(LocalDate.now().plusDays(1000));

        Employee employee = new Employee("Harry", 100_000, 2019, 10, 16);
        System.out.println(employee);
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        System.out.println(employee.getHireDay());
        employee.raiseSalary(50.0);
        System.out.println(employee.getSalary());

        Employee harry2 = new Employee("Harry", 200000, 2016, 6, 10);
        Employee carl = new Employee("Carl", 50000, 2010, 9, 6);
        System.out.println(harry2);
        System.out.println(carl);
        System.out.println(employee.equals(harry2));
        System.out.println(employee.equals(carl));

        System.out.println(employee.getNextId());
        System.out.println(Employee.getNextId());

        System.out.println(new Employee());
        System.out.println(new Employee());

        System.out.println(sqrt(36.0));
        System.out.println(sin(PI / 6.0));
    }

    private static void printMonthCalendarOfDate(LocalDate date) {
        System.out.println(date);
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1); // start of month
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < date.getDayOfWeek().getValue(); i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            System.out.print(date.getDayOfMonth() == today ? "*" : " ");
            if (date.getDayOfWeek().getValue() == 7)
                System.out.println();
            date = date.plusDays(1);
        }
        System.out.println();
    }
}
