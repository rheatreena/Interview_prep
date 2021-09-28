package facade;

/**
 * @author trinapal
 */
public class Samsung implements Mobileshop {
    @Override
    public void mobileNo() {
        System.out.print("Samsung");
    }

    @Override
    public void price() {
        System.out.print("20$");
    }
}
