package love.lipbcu.learnjava.p034_thread;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread threadToInterrupt = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("working " + i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // Thread.currentThread().isInterrupted() 不会被置位
                    break;
                }
            }
        });
        threadToInterrupt.start();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                threadToInterrupt.interrupt();
            }
        }, 1000);
        threadToInterrupt.join();

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
