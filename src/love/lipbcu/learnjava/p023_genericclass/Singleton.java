package love.lipbcu.learnjava.p023_genericclass;

/* Won't work
public class Singleton<T> {
    private static T singleInstance;

    public static T getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new T();
        }
        return singleInstance;
    }
}
*/
