import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author trinapal
 */
public class ThreadInterferenceSynchronization {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Counter counter = new Counter();
        for(int i =0; i<100; i++)
        {
            executorService.submit( () -> counter.increment());
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final count is : " + counter.getCounter());
    }
}

class Counter {
     private int counter = 0;

     public synchronized void increment() //without synchronized race condition happens and this code section is called critical section
     {
         counter = counter+1;
     }
     public int getCounter(){
         return counter++;
     }
}
