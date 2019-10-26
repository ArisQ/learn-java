package love.lipbcu.learnjava.p014_variadicfunctions;

import java.time.LocalDate;
import java.util.Date;

public class VariadicFunctions {
    public static void main(String[] args) {
        printObjects(1, 2.0, 3L, 4.0F, 'A', "Hello", new Date(), LocalDate.now());
    }

    public static void printObjects(Object... objects) {
        for (Object object : objects)
            System.out.println(object.getClass().getName() + ": " + object.toString());
    }
}
