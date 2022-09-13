package practiceLambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static void main(String[] args) {

        // another test
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        testExecutorService(executorService);
        executorService.execute(() -> System.out.println("test asynchronous task "  + Thread.currentThread().getName()));
        executorService.shutdown(); // mandatory , otherwise the code will run forever

    }

    static Runnable task = () -> {
        int value =0;
       for(int i = 0; i<4; i++) {
           try {
               System.out.println(" Thread " + Thread.currentThread().getName() + "  priority " + Thread.currentThread().getPriority());
               value = i * 2;
               TimeUnit.SECONDS.sleep(2);
               System.out.println(" value " + value);
           }catch(InterruptedException ex){
               ex.printStackTrace();
           }
       }
    };
    public static void testExecutorService(ExecutorService executorService) {
        executorService.submit(() -> {
            for (int i = 0; i < 4; i++) {
                task.run();
                System.out.println(" end of executor service ");
            }

        });
        /*try {
            System.out.println("attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }*/
    }


}
