/**
 * @author trinapal
 */
public class ThreadLocalMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadTask  threadTask = new ThreadTask();
        Thread thread1 = new Thread(threadTask);
        Thread thread2 = new Thread(threadTask, "thread-B");
        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread2 to terminate
        thread2.join(); ////wait for thread1 to terminate


    }
}
