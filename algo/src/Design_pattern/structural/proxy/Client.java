package proxy;

/**
 * @author trinapal
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String name = "Admin";
        String password = "Admin123@";
         DatabaseExecuteProxy proxy = new DatabaseExecuteProxy(name, password);
         proxy.executeDateBase("DELETE this");

        String name1 = "Admi1n";
        String password1 = "Admin1123@";
        DatabaseExecuteProxy proxy1 = new DatabaseExecuteProxy(name1, password1);
        proxy1.executeDateBase("DELETE this");


    }
}
