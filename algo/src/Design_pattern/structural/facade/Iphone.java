package facade;

/**
 * @author trinapal
 */
public class Iphone implements Mobileshop {
    @Override
    public void mobileNo() {
        System.out.print("Iphone");
    }

    @Override
    public void price() {
        System.out.print("$190");
    }
}
