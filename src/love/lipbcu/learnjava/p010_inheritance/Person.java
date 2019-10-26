package love.lipbcu.learnjava.p010_inheritance;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
