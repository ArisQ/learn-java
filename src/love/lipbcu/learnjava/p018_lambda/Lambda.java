package love.lipbcu.learnjava.p018_lambda;

import love.lipbcu.learnjava.p008_array.Array;
import love.lipbcu.learnjava.p017_interface.LengthComparator;
import love.lipbcu.learnjava.p017_interface.TimePrinter;

import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        Timer timer = new Timer(1000, actionEvent -> System.out.println("This time is " + new Date()));
        timer.start();

        String[] friends = {"Peter", "Paul", "Mary"};
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(friends));

        new Timer(1000, System.out::println).start();

        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Paul");
        names.add("Mary");
        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> people = stream.collect(Collectors.toList());
        System.out.println(names);
        System.out.println(stream);
        System.out.println(people);

        repeat(5, () -> System.out.println("Countdown"));
        repeat(5, i -> System.out.println("Countdown: " + (4 - i)));

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; ++i)
            action.run();
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; ++i)
            action.accept(i);
    }
}
