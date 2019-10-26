package love.lipbcu.learnjava.p011_objectclass;

public class ObjectClass {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Manager manager = new Manager();
        System.out.println(employee);
        System.out.println(manager);
        System.out.println(employee.equals(employee));
        System.out.println(employee.equals(null));
        System.out.println(employee.equals(manager));
        System.out.println(manager.equals(employee));

        System.out.println(employee.getClass());
        System.out.println(employee.getClass().getName());
        System.out.println(employee.getClass().getSuperclass());
        System.out.println(manager.getClass());
        System.out.println(manager.getClass().getName());
        System.out.println(manager.getClass().getSuperclass());

        System.out.println(employee.hashCode());
        System.out.println(manager.hashCode());
        System.out.println("abc".hashCode());
        System.out.println(Character.valueOf('A').hashCode());
        System.out.println(Integer.valueOf(0).hashCode());
        System.out.println(Integer.valueOf(1).hashCode());
    }
}
