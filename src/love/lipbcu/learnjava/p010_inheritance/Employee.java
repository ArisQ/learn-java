package love.lipbcu.learnjava.p010_inheritance;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
    /**
     * Next available id.
     */
    private static int nextId = 1;

    private final int id;
    private String name;
    private double salary;
    private LocalDate hireDay;

    // static initialization block
    static {
        nextId = new Random().nextInt(1000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee() {
        this("", 0, 1970, 1, 1);
    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public final String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public double raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
        return raise;
    }

    public boolean equals(Employee other) {
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return super.toString() + "<" + id + "," + name + "," + salary + "," + hireDay + ">";
    }

    public static int getNextId() {
        return nextId;
    }
}
