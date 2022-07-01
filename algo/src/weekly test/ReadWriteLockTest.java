import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author trinapal
 */
public class ReadWriteLockTest
{
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CounterVar counter = new CounterVar();
        executorService.submit(() -> System.out.println(" write " + counter.increment()));
        executorService.submit(() -> System.out.println( " read " + counter.getCount()));
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
    }
}

class CounterVar {
    ReadWriteLock lock = new ReentrantReadWriteLock();

    private AtomicInteger counting = new AtomicInteger(0);
    private int count =0;

    int increment()
    {
        lock.writeLock().lock();
        try {
            /*count = count + 2;
            return count;*/;
            return counting.incrementAndGet();
        }finally {
            lock.writeLock().unlock();
        }

    }
    int getCount()
    {
        lock.readLock().lock();
        try {
            //return count;
            return counting.get();
        }finally {
            lock.readLock().unlock();
        }
    }
}
