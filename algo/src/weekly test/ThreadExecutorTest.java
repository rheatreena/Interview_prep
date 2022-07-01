import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author trinapal
 */
public class ThreadExecutorTest {

    static int MAX_THREADS= 4;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task t1 = new Task("task_1");
        Task t2 = new Task("task_2");
        Task t3 = new Task("task_3");
        Task t4 = new Task("task_4");
        Task t5 = new Task("task_5");
        Task t6 = new Task("task_6");
        Task t7 = new Task("task_7");

        //executor
        ExecutorService executorServicePool = Executors.newFixedThreadPool(MAX_THREADS);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(MAX_THREADS);
        executorServicePool.execute(t1);
        executorServicePool.execute(t2);
        executorServicePool.execute(t7);
        executorServicePool.execute(t3);
        executorServicePool.execute(t4);
        executorServicePool.execute(t6);
        System.out.println("submit " + executorServicePool.submit(t5));

        //executorServicePool.shutdown();

        System.out.println("--------------------------------BREAK----------------------------------");

        CallableTask t11 = new CallableTask("task_11");
        CallableTask t12 = new CallableTask("task_12");
        CallableTask t13 = new CallableTask("task_13");
        CallableTask t14 = new CallableTask("task_14");
        CallableTask t15 = new CallableTask("task_15");
        CallableTask t16 = new CallableTask("task_16");
        CallableTask t17 = new CallableTask("task_17");

        Future future = executorServicePool.submit(t11);
        System.out.println("testing result " +  future.get());
        executorServicePool.shutdown();

    }
}

class CallableTask implements Callable {
    private String name;
    CallableTask(String name){
        this.name = name;
    }
    @Override
    public Object call() throws Exception {
        for(int i =0; i<=3; i++){
            DateFormat d = new SimpleDateFormat("hh:mm:ss");
            System.out.println("executing time  for callable" + this.name + " " +d.format(Calendar.getInstance().getTime()));
        }
        Thread.sleep(3000);
        return  "result";
    }
}
class Task implements Runnable{

    private String name;

    Task(String s){
        name = s;
    }
    @Override
    public void run() {
        try {
        for(int i =0; i<5; i++) {
            if (i == 0) {
                DateFormat d = new SimpleDateFormat("hh:mm:ss");
                System.out.println("Initialization time  for " + this.name + " " +d.format(Calendar.getInstance().getTime()));
            } else {
                DateFormat d = new SimpleDateFormat("hh:mm:ss");
                System.out.println("executing time  for " + this.name + " " +d.format(Calendar.getInstance().getTime()));
            }

            Thread.sleep(2000);
            System.out.println(name + " complete");
        }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

}
