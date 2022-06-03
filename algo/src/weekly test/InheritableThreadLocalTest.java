/**
 * @author trinapal
 */
public class InheritableThreadLocalTest {

    /*
    InheritableThreadLocal is a subclass of ThreadLocal. Instead of of having a particular value to a threadlocal, it grant to access the value of that thread to its child class.
     */

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static InheritableThreadLocal <String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->
        {
            System.out.println("===== Thread 1 =====");
            threadLocal.set("Thread 1 - ThreadLocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");

        System.out.println(threadLocal.get());
        System.out.println(inheritableThreadLocal.get());

        Thread childThread = new Thread(() -> {
            System.out.println("===== child Thread =====");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });
        childThread.start();
        } );
        thread1.start();

        Thread thread2 = new Thread (() -> {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println("===== Thread 2 =====");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });
        thread2.start();


    }
}
