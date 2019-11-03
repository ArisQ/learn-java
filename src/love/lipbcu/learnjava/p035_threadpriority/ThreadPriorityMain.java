package love.lipbcu.learnjava.p035_threadpriority;

public class ThreadPriorityMain {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int j = 0; j < 1000; ++j)
                System.out.print(Thread.currentThread().getId());
        };
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        System.out.println("Running in main thread");
    }
}
