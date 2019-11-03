package love.lipbcu.learnjava.p034_thread;

public class ThreadMain {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                for (int j = 0; j < 100; ++j) {
                    System.out.println("Running in thread " + Thread.currentThread().getName() + " " + j);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(r);
            thread.start();
        }
        System.out.println("Running in main thread");
    }
}
