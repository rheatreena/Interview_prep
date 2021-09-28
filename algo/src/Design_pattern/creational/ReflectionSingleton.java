import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author trinapal
 */
public class ReflectionSingleton {

    public static void main(String[] args) {
        Singleton instanceOne = Singleton.get_lazy_instance();
        Singleton instanceTwo = null;

        Constructor [] constructors = Singleton.class.getDeclaredConstructors();
        for(Constructor constuctor : constructors){
            constuctor.setAccessible(true);
            try {
                instanceTwo = (Singleton) constuctor.newInstance();
                break;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(instanceOne.hashCode());
            System.out.println(instanceTwo.hashCode());
        }
    }
}
