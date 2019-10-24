package love.lipbcu.learnjava.p004_string;

public class StringMain {
    public static void main(String[] args) {
        String a = "This is a string";
        System.out.println(a);

        String b = "字符串";
        System.out.println(b);

        System.out.println(a + b);
        System.out.println(a + 123);
        System.out.println(a + ". Yep.");

        System.out.println(a.substring(5, 7));

        // a[0] = 'a'; // Error

        System.out.println(a.equals(b));
        System.out.println(a.equals("This is a string"));
        System.out.println(a.equals("this is a string"));
        System.out.println(a.equalsIgnoreCase("this is a string"));

        String emptyStr = "";
        System.out.println(emptyStr);
        System.out.println(emptyStr.length());
        System.out.println(emptyStr.length() == 0);

        String nullStr = null;
        System.out.println(nullStr);
        try {
            System.out.println(nullStr.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // code point & code unit
        String complicatedStr = "abc\uD835\uDD46abc"; // U+1D546 BE:D8 35 DD 46 LE: 35 D8 46 DD
        System.out.println(complicatedStr);
        System.out.println(complicatedStr.length());
        System.out.println(complicatedStr.codePointCount(0, complicatedStr.length()));
        for (int i = 0; i < complicatedStr.length(); ++i) {
            System.out.println(complicatedStr.charAt(i));
        }
        for (int i = 0; i < complicatedStr.codePointCount(0, complicatedStr.length()); ++i) {
            System.out.println(complicatedStr.offsetByCodePoints(0, i) + "\t" +
                    Integer.toHexString(complicatedStr.codePointAt(i)) + "\t" +
                    complicatedStr.codePointAt(i) + "\t" +
                    complicatedStr.codePointAt(complicatedStr.offsetByCodePoints(0, i)) + "\t" +
                    Character.isSupplementaryCodePoint(complicatedStr.codePointAt(i)) + "\t" +
                    Character.isSurrogate(complicatedStr.charAt(i))
            );
        }
        System.out.println(complicatedStr.codePoints().toArray());

        // String API
        String str = "  StringAPI";
        System.out.println(str);
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());
        System.out.println(str.startsWith("String"));
        System.out.println(str.endsWith("API"));
        System.out.println(String.join(" ", "abc","def","xyz"));

        // StringBuilder
        char c = (char) ('a' + Math.floor(Math.random() * 26));
        StringBuilder builder = new StringBuilder();
        builder.append('A');
        builder.appendCodePoint(0x1D546);
        builder.append(c);
        System.out.println(builder.toString());
    }
}
