package love.lipbcu.learnjava.p036_threadsync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSyncMain {
    public static void main(String[] args) {
        class IntStore {
            private int value;

            IntStore(int value) {
                this.value = value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }

            public void add(int by) {
                value += by;
            }

            public void minus(int by) {
                value -= by;
            }

            public void addAndMinus(int by) {
                add(by);
                minus(by);
            }

            public synchronized void syncAddAndMinus(int by) {
                addAndMinus(by);
            }
        }

        final int threadNum = 1000;
        final int loopCount = 1000;
        final int range = 100;
        IntStore intStore = new IntStore(0);
        System.out.println("Start unsync, value=" + intStore.getValue());
        runThread(threadNum, () -> {
            for (int i = 0; i < loopCount; ++i) {
                int v = (int) Math.round(Math.random() * range);
                intStore.addAndMinus(v);
                // 不在循环内输出，否则线程中断大概类发生在输出中，无法体现出竞争条件
                // System.out.println("operate with " + v + " , result=" + intStore.getValue());
            }
        });
        System.out.println("Unsync finished, result=" + intStore.getValue());

        intStore.setValue(0);
        ReentrantLock lock = new ReentrantLock();
        System.out.println("Start sync with lock, value=" + intStore.getValue());
        runThread(threadNum, () -> {
            for (int i = 0; i < loopCount; ++i) {
                int v = (int) Math.round(Math.random() * range);
                lock.lock();
                intStore.addAndMinus(v);
                lock.unlock();
            }
        });
        System.out.println("Sync with lock finished, result=" + intStore.getValue());

        intStore.setValue(0);
        System.out.println("Start sync with synchronized, value=" + intStore.getValue());
        runThread(threadNum, () -> {
            for (int i = 0; i < loopCount; ++i) {
                int v = (int) Math.round(Math.random() * range);
                intStore.syncAddAndMinus(v);
            }
        });
        System.out.println("Sync with synchronized finished, result=" + intStore.getValue());

        // consumer & producer
        System.out.println("========== Consumer and Producer ========== ");
        intStore.setValue(0);
        final int max = 20; // 最大容量，注意：如果max较小，可能生产无法放入同时消费不够取出，造成死锁
        final int maxProduce = 10; // 最大生产，最小为1
        final int maxConsume = 10; // 最大消费，最小为1
        final int workTimes = 10; // 消费执行次数
        Condition condition = lock.newCondition();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < workTimes; i++) {
                int product = 1 + (int) Math.round(Math.random() * (maxProduce - 1));
                lock.lock();
                try {
                    while (intStore.getValue() + product > max) {
                        System.out.println("Queue is full. produce=" + product + " current=" + intStore.getValue() + " max=" + max);
                        condition.await();
                    }
                    intStore.add(product);
                    System.out.println("Produce " + product + " result=" + intStore.getValue());
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            lock.lock();
            intStore.add(maxConsume * workTimes); // 结束生产，通过放入足够的product来满足消费者结束条件
            System.out.println("Produce " + maxConsume * workTimes + " to finish");
            lock.unlock();
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < workTimes; i++) {
                int need = 1 + (int) Math.round(Math.random() * (maxConsume - 1));
                lock.lock();
                try {
                    while (intStore.getValue() < need) {
                        System.out.println("Queue is empty. need=" + need + " current=" + intStore.getValue());
                        condition.await();
                    }
                    intStore.minus(need);
                    System.out.println("Consume with " + need + " result=" + intStore.getValue());
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        consumer.start();
        producer.start();
        try {
            consumer.join();
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runThread(int threadNum, Runnable runnable) {
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; ++i) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        for (int i = 0; i < threadNum; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
