package adapter;

/**
 * @author trinapal
 */
public class WebDriverAdapter implements WebAdapter{

    IDriver iDriver;


    // initialize the variable
     WebDriverAdapter(IDriver iDriver){
         this.iDriver = new IDriver();
     }
    @Override
    public void getElement() {
        iDriver.findElement();
    }

    @Override
    public void selectElement() {
        iDriver.clieckElement();

    }
}
