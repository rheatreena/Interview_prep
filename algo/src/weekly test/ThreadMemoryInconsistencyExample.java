/**
 * @author trinapal
 */
//in debug it will give correct result because of timing issue
public class ThreadMemoryInconsistencyExample {
    public static  volatile boolean sayHello = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!sayHello){

            }
                System.out.println(" First time Hello");
            while(sayHello){

            }
                System.out.println(" now say hello");
        });
        thread.start(); // get into runnable mode
        Thread.sleep(1000);
        System.out.println(" Good Bye");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println(" See you again");
        sayHello = false;

    }

}
