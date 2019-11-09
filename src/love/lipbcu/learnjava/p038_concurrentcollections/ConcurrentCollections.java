package love.lipbcu.learnjava.p038_concurrentcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollections {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        int threadNum = 10;
        ArrayList<Thread> threads = new ArrayList<>();

        System.out.println(map);
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    // not atomic
                    Integer v = map.get(0);
                    map.put(0, v == null ? 1 : v + 1);
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads)
            thread.join();
        threads.clear();
        System.out.println("concurrent update with nonatomic method, result: " + map);

        map.remove(0);
        System.out.println("remove element<key=0>, result:" + map);
        System.out.println(map);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++)
                    map.compute(0, (k, v) -> v == null ? 1 : v + 1); // atomic
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads)
            thread.join();
        threads.clear();
        System.out.println("concurrent update with compute, result: " + map);

        map.remove(0);
        System.out.println("remove element<key=0>, result:" + map);
        System.out.println(map);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++)
                    map.merge(0, 1, Integer::sum); // atomic
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads)
            thread.join();
        threads.clear();
        System.out.println("concurrent update with merge, result: " + map);

        // 批操作
        map.remove(0);
        for (int i = 0; i < 20; i++)
            map.put(i, i * i);
        System.out.println(map);
        int searchResult = map.search(2, (k, v) -> v == 100 ? k : null);
        System.out.println("search result=" + searchResult);

        map.forEach(2, (k, v) -> System.out.println(k + "->" + v));

        int sum = map.reduceValues(2, Integer::sum);
        System.out.println("sum of values: " + sum);

        // 并发集视图
        Set<Integer> keySet = map.keySet(-1);
        System.out.println("key set: " + keySet);
        keySet.add(100); // add with default value -1
        System.out.println("map after add by key set with default value " + map);

        // 并行数组算法
        int intCount = 10;
        int[] ints = new int[intCount];
        for (int i = 0; i < intCount; i++)
            ints[i] = (int) Math.floor(Math.random() * 100);
        System.out.println("array: " + Arrays.toString(ints));
        Arrays.parallelSort(ints);
        System.out.println("parallel sort: " + Arrays.toString(ints));
        Arrays.parallelSetAll(ints, i -> i * i);
        System.out.println("parallel set: " + Arrays.toString(ints));

        int intCount2 = 1000000;
        ints = new int[intCount2];
        Arrays.parallelSetAll(ints, i -> (int) Math.floor(Math.random() * 100));
        long start = System.currentTimeMillis();
        Arrays.parallelSort(ints);
        long end = System.currentTimeMillis();
        System.out.println("sorted with parallel sort, time: " + (end - start) + "ms");
        Arrays.parallelSetAll(ints, i -> (int) Math.floor(Math.random() * 100));
        start = System.currentTimeMillis();
        Arrays.sort(ints);
        end = System.currentTimeMillis();
        System.out.println("sorted, time: " + (end - start) + "ms");

        ints = new int[intCount];
        Arrays.parallelSetAll(ints, i -> i + 1);
        System.out.println("array: " + Arrays.toString(ints));
        Arrays.parallelPrefix(ints, (x, y) -> x * y);
        System.out.println("parallel prefix: " + Arrays.toString(ints));
    }
}
