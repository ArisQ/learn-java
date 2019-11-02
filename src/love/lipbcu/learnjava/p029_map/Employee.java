package love.lipbcu.learnjava.p029_map;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
    private static int nextId = 1;

    private int id;
    private String name;

    // static initialization block
    static {
        nextId = new Random().nextInt(1000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee<" + id + "," + name + ">";
    }
}
