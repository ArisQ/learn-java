package love.lipbcu.learnjava.p040_executorandthreadpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorAndThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // thread pool
        ExecutorService pool = Executors.newCachedThreadPool();
        int taskNum = 10;
        ArrayList<Future<Double>> results = new ArrayList<>();
        results.ensureCapacity(taskNum);
        for (int i = 0; i < taskNum; i++) {
            Future<Double> result = pool.submit(() -> {
                double v = Math.random();
                try {
                    Thread.sleep((int) (v * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return v;
            });
            results.add(result);
        }
        for (Future<Double> result : results)
            System.out.println("result=" + result.get());
        pool.shutdown();
        System.out.println("largest pool size=" + ((ThreadPoolExecutor) pool).getLargestPoolSize());

        // scheduled execution 预定执行
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        System.out.printf("[%d] start schedule\n", System.currentTimeMillis());
        scheduled.schedule(() -> System.out.printf("[%d] Scheduled", System.currentTimeMillis()), 1000, TimeUnit.MILLISECONDS);
        System.out.printf("[%d] schedule succeed\n", System.currentTimeMillis());
        scheduled.shutdown();
        scheduled.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        // 控制任务组
        ExecutorService executor = Executors.newCachedThreadPool();
        int intCount = 10;
        int[] ints = new int[intCount];
        Arrays.setAll(ints, i -> (int) Math.floor(Math.random() * 1000));
        System.out.println("ints: " + Arrays.toString(ints));
        // find min uses threads, don't do this
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                Thread.sleep(ints[finalI]);
                return ints[finalI];
            });
        }
        Integer minResult = executor.invokeAny(tasks);
        System.out.println("min result by threads: " + minResult);
        // sort uses threads, don't do this
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(executor);
        for (Callable<Integer> task : tasks)
            service.submit(task);
        System.out.println("sort result by threads:");
        for (int i = 0; i < tasks.size(); i++)
            System.out.println(service.take().get());

        // Fork-Join
        System.out.println("count odds, ints: " + Arrays.toString(ints));
//        RecursiveTask<Integer> countOddTask
        class OddCounter extends RecursiveTask<Integer> {
            private int[] values;
            private int from;
            private int to;

            public OddCounter(int[] values, int from, int to) {
                this.values = values;
                this.from = from;
                this.to = to;
            }

            @Override
            protected Integer compute() {
                if (to - from == 1)
                    return values[from] % 2 == 0 ? 0 : 1;
                int mid = (from + to) / 2;
                OddCounter first = new OddCounter(values, from, mid);
                OddCounter second = new OddCounter(values, mid, to);
                invokeAll(first, second);
                return first.join() + second.join();
            }
        }
        OddCounter counter = new OddCounter(ints, 0, ints.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(counter);
        System.out.println("count odd with fork-join, result=" + counter.join());

        // Completable Future
        final int maxValue = 1000;
        CompletableFuture.completedFuture((int) Math.floor(Math.random() * maxValue * 2))
                .thenApply((Integer v) -> {
                    System.out.println("checking value: " + v);
                    if (v < maxValue)
                        return v;
                    return maxValue;
                })
                .thenAccept((Integer v) -> {
                    System.out.println("print value: " + v);
                });
    }
}
