package love.lipbcu.learnjava.p019_innerclass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class InnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.run("String passed to inner class");

        System.out.println("=== Run by outer.new.Inner()");
        outer.setValue("String passed to inner class 1");
        Outer.Inner inner = outer.new Inner();
        inner.action();

        // 局部内部类
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, time is " + new Date());
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(1000, listener);
        t.start();

        // 匿名内部类
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("[anonymous inner class] At the tone, time is " + new Date());
            }
        };
        Timer t2 = new Timer(1000, listener);
        t2.start();

        System.out.println(new ArrayList<String>() {{
            add("Harry");
            add("Tony");
        }});

        System.out.println(ArrayAlg.minmax(new double[]{1.0, 2.0, 3.0}));

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}
