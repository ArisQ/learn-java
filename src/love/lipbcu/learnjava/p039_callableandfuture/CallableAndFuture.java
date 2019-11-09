package love.lipbcu.learnjava.p039_callableandfuture;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Double> myComputation = Math::random;
        FutureTask<Double> task = new FutureTask<>(myComputation);
        Thread t = new Thread(task);
        t.start();
        Double result = task.get();
        System.out.println(result);
    }
}
