import java.io.Serializable;

/**
 * @author trinapal
 */
public class Singleton implements Serializable {

    /*
    * This design pattern is a  creational design pattern means it restricts the creation of the instance.
    * This pattern won't allow to create instance from outside the class.
    *
    * How will it be possible ?
    * 1. make the constructor private
    * 2. make the instance as a static variable
    *
    * Then how other class will access the instance?
    *  => There  will be a public method to access the instance
    * */

    private Singleton() {

    }
    private static final Singleton instance = new Singleton();
    /*
    This is called Eager Initialization
     */
    public static Singleton get_instance()
    {
        return instance;
    }
    /*
    This is called Lazy Initialization
     */
    public static Singleton get_lazy_instance(){
        if (instance == null){
            return new Singleton();
        }
            return instance;

    }

    private static Singleton instance_static;
    /*
    This is static initialization. This happens when the class loads
     */
   static{
        try{
            instance_static = new Singleton();
        }catch (Exception exception){
            throw  new RuntimeException("Error occured");
        }
    }

    public static Singleton get_static_instance(){
       return instance_static;
    }


    /*
    Threadsafe singleton - here we will make the class synchronized
     */

    public synchronized Singleton get_threadsafe_instance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }

    /*
    Double checked locking
     */

    public synchronized Singleton get_double_lock_instance(){
        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    return new Singleton();
                }
            }
        }
        return  instance;
    }

    /*
    Bill pugh Singleton Initialization
     */

    private static class SingletonHelper{
        private static final Singleton TEST_SINGLETON_INSTANCE  = new Singleton();

    }

    public static Singleton billPurgSingleton_getinstance(){
        return SingletonHelper.TEST_SINGLETON_INSTANCE;
    }


    /*
    Another way is using volatile variable
     what is volatile variable  ?
     => volatile variable helps to achieve tghread safely. We can do this using synchronized but sometimes we dont need atomicity . like using synchronization, if one thread is working
     on some method/block, then other threads need to wait to acquire the lock. This is called mutual exclusion/atomicity

     And sometimes if one thread is changing some data, it is visible to other processes or threads - visibility

     using volatile, we can achieve only the vuisibility. Volatile variable never gets cached.

     static variables can be shared among all the threads
     */

    static volatile Singleton volatile_instance;
    public static Object mutex = new Object();

    public static Singleton get_volatile_instance(){
        Singleton result =  volatile_instance;
        if(result == null){
            synchronized (mutex){
                result = volatile_instance;
                if( result == null){
                    volatile_instance = result = new Singleton();
                }
            }
        }
        return result;
    }

}
