package love.lipbcu.learnjava.p011_objectclass;

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

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject))
            return false;
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }

}
