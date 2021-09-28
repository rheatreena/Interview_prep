/**
 * @author trinapal
 */
public class ChatServiceImpl implements MessageService {

    @Override
    public void sendMessage(String to, String message) {
        System.out.println("chat " +  message + "  sent to  " + to);
    }
}
