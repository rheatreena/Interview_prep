/**
 * @author trinapal
 */

//structural
public class ProxyPatternMainTest {
    public static void main(String[] args) {
        RemoteProxy remoteProxy = new RemoteProxy("Trina");
        remoteProxy.grantAccess();
    }
}
