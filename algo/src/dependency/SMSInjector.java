/**
 * @author trinapal
 */
public class SMSInjector implements Injector {
    @Override
    public Consumer getConsumer() {
        return new ClientApplication(new SMSServiceImpl());
    }
}
