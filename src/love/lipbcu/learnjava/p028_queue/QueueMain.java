package love.lipbcu.learnjava.p028_queue;

import java.time.LocalDate;
import java.util.*;

public class QueueMain {
    public static void main(String[] args) {
        Deque<String> strDeque = new ArrayDeque<>(3);
        Queue<String> strQueue = (Queue<String>) strDeque;
        strQueue.add("Amy");
        strQueue.add("Bob");
        System.out.println(strQueue);

        strDeque.addFirst("Carl");
        System.out.println(strQueue);

        PriorityQueue<LocalDate> pg = new PriorityQueue<>();
        pg.add(LocalDate.of(1906, 12, 9));
        pg.add(LocalDate.of(1815, 12, 10));
        pg.add(LocalDate.of(1903, 12, 3));
        pg.add(LocalDate.of(1910, 6, 22));
        System.out.println("iterating...");
        for (LocalDate date : pg)
            System.out.println(date);
        System.out.println("removing...");
        while (!pg.isEmpty())
            System.out.println(pg.remove());
    }
}
