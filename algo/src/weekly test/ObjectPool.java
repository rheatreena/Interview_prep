import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author trinapal
 */
public abstract class ObjectPool<T> {
    private ConcurrentLinkedQueue<T> pool;

    /*

   ScheduledExecutorService starts a special task in a separate thread and observes
   the minimum and maximum number of objects in the pool periodically in a specified
    time (with parameter validationInterval).
   When the number of objects is less than the minimum, missing instances will be created.
   When the number of objects is greater than the maximum, too many instances will be removed.
   This is sometimes useful for the balance of memory consuming objects in the pool.
*/
    private ScheduledExecutorService executorService;

    public ObjectPool(final int minObjects)
    {
        // initialize pool

        initialize(minObjects);

    }

    private void initialize(final int minObjects)  {
        pool = new ConcurrentLinkedQueue<T>();
        for (int i = 0; i < minObjects; i++) {
            pool.add(createObject());
        }
    }

    /*
       Creates a new object.
        @return T new object
    */
    protected abstract T createObject();

    /*
     Returns object back to the pool.
     @param object object to be returned
 */
    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }
    /*
         Shutdown this pool.
     */
    public void shutdown(){
        if (executorService != null){
            executorService.shutdown();
        }
    }

    /*
     Gets the next free object from the pool. If the pool doesn't contain any objects,
     a new object will be created and given to the caller of this method back.

     @return T borrowed object
 */
    public T borrowObject() {
        T object;
        if ((object = pool.poll()) == null)
        {
            object = createObject();
        }
        return object;
    }

    /*
      Creates the pool.
      @param minObjects:   minimum number of objects residing in the pool.
      @param maxObjects:   maximum number of objects residing in the pool.
      @param validationInterval: time in seconds for periodical checking of
         minObjects / maxObjects conditions in a separate thread.
      When the number of objects is less than minObjects, missing instances will be created.
      When the number of objects is greater than maxObjects, too many instances will be removed.
    */
    public ObjectPool(final int minObjects, final int maxObjects, final long validationInterval) {
        // initialize pool
        initialize(minObjects);
        // check pool conditions in a separate thread
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable()  // annonymous class
        {
            @Override
            public void run() {
                int size = pool.size();

                if (size < minObjects) {
                    int sizeToBeAdded = minObjects + size;
                    for (int i = 0; i < sizeToBeAdded; i++) {
                        pool.add(createObject());
                    }
                } else if (size > maxObjects) {
                    int sizeToBeRemoved = size - maxObjects;
                    for (int i = 0; i < sizeToBeRemoved; i++) {
                        pool.poll();
                    }
                }
            }
        }, validationInterval, validationInterval, TimeUnit.SECONDS);
    }
}
