package love.lipbcu.learnjava.p037_blockingqueue;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {
    public static void main(String[] args) {
        int queueSize = 10;
        BlockingQueue<Integer> intQueue = new ArrayBlockingQueue<>(queueSize);
        // empty get
        try {
            int v = intQueue.element();
            System.out.println("element from empty succeed, value=" + v);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            int v = intQueue.remove();
            System.out.println("remove succeed from empty queue, value=" + v);
        } catch (Exception e) {
            System.out.println("remove failed from empty queue, error:");
            e.printStackTrace();
        }
        Timer timer = new Timer();
        int delay = 5000;
        System.out.printf("waiting %d milliseconds before adding\n", delay);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int v = 0;
                System.out.printf("[%d] add element to queue, value=%d\n", System.currentTimeMillis(), v);
                intQueue.add(v);
            }
        }, 5000);
        try {
            System.out.printf("[%d] taking from empty queue, will now blocked\n", System.currentTimeMillis());
            int v = intQueue.take();
            System.out.printf("[%d] taking succeed, value=%d\n", System.currentTimeMillis(), v);
        } catch (InterruptedException e) {
            System.out.printf("[%d] taking failed, error:\n", System.currentTimeMillis());
            e.printStackTrace();
        }
        System.out.println("poll empty queue, value=" + intQueue.poll());
        System.out.println("peak empty queue, value=" + intQueue.peek());

        // full add
        for (int i = 0; i < queueSize; i++)
            intQueue.add(i);
        System.out.println("queue is full, values=" + intQueue);
        try {
            intQueue.add(0);
        } catch (Exception e) {
            System.out.println("add value to queue failed:");
            e.printStackTrace();
        }
        System.out.printf("waiting %d milliseconds before remove\n", delay);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("[%d] remove element from queue\n", System.currentTimeMillis());
                intQueue.remove();
            }
        }, delay);
        try {
            System.out.printf("[%d] put element to full queue, will now blocked\n", System.currentTimeMillis());
            intQueue.put(0);
            System.out.printf("[%d] put succeed\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.printf("[%d] put failed, error:\n", System.currentTimeMillis());
            e.printStackTrace();
        }
        System.out.println("offer element to full queue, result=" + intQueue.offer(0));

        System.out.println("all done");
        timer.cancel();
    }
}
