package love.lipbcu.learnjava.p010_inheritance;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
        bonus = 0;
    }

    public Manager(String name, double salary, int year, int month, int day) {
        this(name, salary, year, month, day, 0);
    }

    public Manager(String name, double salary, int year, int month, int day, int bonus) {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    /* can not override due to super method is final
    @Override
    public String getName() {
        return super.getName();
    }
    */
}
