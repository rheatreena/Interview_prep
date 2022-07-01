import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author trinapal
 */
public class ReentrantLockTest
{
    public static void main(String[] args) throws InterruptedException {
        ReentrantTest reentrantTest = new ReentrantTest();
       /* Thread thread = new Thread(() -> {

            reentrantTest.increment();
        });
        thread.start();
        Thread.sleep(1000); */

    ExecutorService executor = Executors.newFixedThreadPool(2);
                executor.submit(() -> reentrantTest.increment() );

                executor.submit( () ->  reentrantTest.increment() );

                executor.shutdown();
            try {
                executor.awaitTermination(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println( " final count " +  reentrantTest.getCount());
    }
}

class ReentrantTest{
    ReentrantLock lock = new ReentrantLock();

    private  int count =0;

    public  void increment()
    {
       try {
           lock.lock();
           count = count + 1;
       }finally {
           lock.unlock();
       }
    }
    public int getCount(){
        return count;
    }
}
