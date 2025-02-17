package love.lipbcu.learnjava.p026_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// redirect input from /usr/share/dict/words. e.g. HashSetMain < /usr/share/dict/words
public class HashSetMain {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iterator = words.iterator();
        for (int i = 0; i <= 20 && iterator.hasNext(); i++)
            System.out.println(iterator.next());
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds");
    }
}
