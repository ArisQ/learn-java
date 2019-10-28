package love.lipbcu.learnjava.p019_innerclass;

/*
 * Run following command to compile and see inner class and access$000 method.
 * javac love/lipbcu/learnjava/p019_innerclass/*
 * javap -private love.lipbcu.learnjava.p019_innerclass.Outer\$Inner
 * javap -private love.lipbcu.learnjava.p019_innerclass.Outer
 */
public class Outer {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void run(String value) {
        this.value = value;

        System.out.println("=== Run by new Inner");
        Inner inner = new Inner();
        inner.action();

        System.out.println("=== Run by this.new Inner");
        inner = this.new Inner();
        inner.action();
    }

    public class Inner {
        public void action() {
            System.out.println("value:            " + value);
            System.out.println("Outer.this.value: " + Outer.this.value);
        }
    }
}
