package proxy;

/**
 * @author trinapal
 */
public class DatabaseExecuteImpl implements Iproxy {
    @Override
    public void executeDateBase(String query) {
        System.out.print("executing the query " +  query);
    }
}
