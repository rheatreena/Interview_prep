package facade;

/**
 * @author trinapal
 */
public class Vivo implements Mobileshop {
    @Override
    public void mobileNo() {
        System.out.print("Vivo");
    }

    @Override
    public void price() {
        System.out.print("$35");
    }
}
