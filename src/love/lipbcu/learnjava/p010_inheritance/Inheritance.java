package love.lipbcu.learnjava.p010_inheritance;

public class Inheritance {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee);

        System.out.println(new Manager());
        Manager manager = new Manager("Tony", 20000, 2015, 7, 13);
        System.out.println(manager);
        manager.setBonus(1000);
        System.out.println(manager.getSalary());

        System.out.println(manager instanceof Manager);
        System.out.println(manager instanceof Employee);

        // abstract class cannot be instantiated
        // Person person = new Person();
        Person person = new Person("Tom") {
            @Override
            public String getDescription() {
                return "My name is " + getName() + ".";
            }
        };
        System.out.println(person);
    }
}
