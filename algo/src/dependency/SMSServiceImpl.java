/**
 * @author trinapal
 */
public class SMSServiceImpl implements MessageService {
    @Override
    public void sendMessage(String to, String message) {
    System.out.println("message " +  message + "  sent to  " + to);
    }
}
