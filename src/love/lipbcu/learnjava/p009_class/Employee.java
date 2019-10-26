package love.lipbcu.learnjava.p009_class;

import java.time.LocalDate;
import java.util.Random;

/**
 * A {@code Employee} object presents a employee of a company.
 * It contains the name, salary and hire day of the employee.
 * An unique id will be generated sequentially.
 * It is also possible to raise the salary for employee by
 * percent.
 * See {@link love.lipbcu.learnjava.p009_class.Employee#raiseSalary}
 * for more details.
 *
 * @see love.lipbcu.learnjava.p009_class.Employee#raiseSalary(double)
 *
 * @author <a href="https://blog.lipbcu.love" target="_">ArisQ</a>
 * @version 1.0.0
 * @since version 1.0.0
 */

public class Employee {
    /**
     * The class name, used to generate employee name with id.
     */
    private static final String CLASS_NAME = "Employee";

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
        if (this.name.equals(""))
            this.name = CLASS_NAME + "#" + id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * Raises the salary of an employee.
     *
     * @param byPercent the percentage by which to raise the salary (e.g. 10 means 100%)
     * @return the amount of the raise
     */
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
        return CLASS_NAME + "<" + id + "," + name + "," + salary + "," + hireDay + ">";
    }

    public static int getNextId() {
        return nextId;
    }
}
