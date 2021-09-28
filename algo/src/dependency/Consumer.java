/**
 * @author trinapal
 */
public interface Consumer {
    void processMessage(String to, String message);
}
