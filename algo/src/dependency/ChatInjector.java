/**
 * @author trinapal
 */
public class ChatInjector implements Injector {
    @Override
    public Consumer getConsumer() {
        return new ClientApplication(new ChatServiceImpl());
    }
}
