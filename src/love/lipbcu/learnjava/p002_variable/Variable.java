package love.lipbcu.learnjava.p002_variable;

public class Variable {
    static final double PI = 3.14;

    public static void main(String[] args) {
        double salary;
        int vacationDays;
        long earthPopulation;
        boolean done;

        System.out.println(Character.isJavaIdentifierStart('0'));
        System.out.println(Character.isJavaIdentifierStart('a'));
        System.out.println(Character.isJavaIdentifierStart('$'));
        System.out.println(Character.isJavaIdentifierStart('\u03C0'));
        System.out.println(Character.isJavaIdentifierStart('+'));

        System.out.println(Character.isJavaIdentifierPart('0'));
        System.out.println(Character.isJavaIdentifierPart('a'));
        System.out.println(Character.isJavaIdentifierPart('$'));
        System.out.println(Character.isJavaIdentifierPart('\u03C0'));
        System.out.println(Character.isJavaIdentifierPart('+'));

        // System.out.println(vacationDays);

        final double CM_PER_INCH = 2.54;
        System.out.println(CM_PER_INCH);

        System.out.println(PI);
    }
}
