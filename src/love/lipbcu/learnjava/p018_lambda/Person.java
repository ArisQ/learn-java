package love.lipbcu.learnjava.p018_lambda;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person<" + name + ">";
    }
}
