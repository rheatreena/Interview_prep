/**
 * @author trinapal
 */
public class ThreadTask implements Runnable{

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set( (int) (Math.random() * 100D) );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get() + " name " + Thread.currentThread().getName());
    }
}
