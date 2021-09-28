package adapter;

/**
 * @author trinapal
 */
public class ChromeDriver implements WebAdapter {
    @Override
    public void getElement() {
        System.out.print("get element");

    }

    @Override
    public void selectElement() {
        System.out.print("selected");

    }


}
