package love.lipbcu.learnjava.p017_interface;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t) {
        return s.length() - t.length();
    }
}
