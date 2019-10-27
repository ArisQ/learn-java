package love.lipbcu.learnjava.p017_interface;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class Interface {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();

        String[] friends = {"Peter", "Paul", "Mary"};
        System.out.println(Arrays.toString(friends));
        Comparator<String> comparator = new LengthComparator();
        Arrays.sort(friends, comparator);
        System.out.println(Arrays.toString(friends));

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}
