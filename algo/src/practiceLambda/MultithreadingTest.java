package practiceLambda;

import java.util.concurrent.TimeUnit;

public class MultithreadingTest {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(" Thread name ::: " + Thread.currentThread().getName() + "  isDemon:: " + Thread.currentThread().isDaemon() + " Thread priority ::: " + Thread.currentThread().getPriority());
            //Thread.currentThread().setDaemon(true);
            Thread.currentThread().setPriority(2);
            System.out.println(" Thread priority ::: " + Thread.currentThread().getPriority() + "  isDemon:: " + Thread.currentThread().isDaemon());

        }).start();


        // Runnable
        Runnable taskDetails = () -> {
            System.out.println(" Thread name ::: " + Thread.currentThread().getName() + "  isDemon:: " + Thread.currentThread().isDaemon() + " Thread priority ::: " + Thread.currentThread().getPriority());
            //Thread.currentThread().setDaemon(true);
            try {
                TimeUnit.SECONDS.sleep(2);
            Thread.currentThread().setPriority(2);
            System.out.println(" Thread priority ::: " + Thread.currentThread().getPriority() + "  isDemon:: " + Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        taskDetails.run();

        new Thread(taskDetails).start();

        System.out.println(" end ");

    }

}
