package adapter;

/**
 * @author trinapal
 */
public class Client {

    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        IDriver iDriver = new IDriver();
        iDriver.findElement();
        iDriver.clieckElement();

        WebDriverAdapter webDriverAdapter = new WebDriverAdapter(iDriver);
        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();
    }
}
