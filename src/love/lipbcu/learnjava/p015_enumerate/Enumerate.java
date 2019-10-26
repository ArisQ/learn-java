package love.lipbcu.learnjava.p015_enumerate;

public class Enumerate {
    public static void main(String[] args) {
        System.out.println(Size.SMALL);
        System.out.println(Size.MEDIUM.toString());

        Size s = Enum.valueOf(Size.class, "LARGE");
        System.out.println(s);

        Size[] sizeValues = Size.values();
        System.out.println("Size.values(): ");
        for (Size v : sizeValues)
            System.out.println(v);

        System.out.println(Size.EXTRA_LARGE.ordinal());
    }
}
