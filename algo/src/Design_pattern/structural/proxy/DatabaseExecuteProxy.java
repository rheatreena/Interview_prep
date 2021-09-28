package proxy;

/**
 * @author trinapal
 */
public class DatabaseExecuteProxy implements Iproxy {

    boolean ifAdmin;
    DatabaseExecuteImpl databaseExecuteImpl;

    DatabaseExecuteProxy(String name, String password){
    if(name == "Admin" && password =="Admin123@"){
        ifAdmin = true;
        databaseExecuteImpl = new DatabaseExecuteImpl();
    }
    }

    @Override
    public void executeDateBase(String query) throws Exception {
        if(!ifAdmin && query.contains("DELETE")){
            throw new Exception(" You are not allowed");
        }
         else{
             databaseExecuteImpl.executeDateBase(query);
        }

    }
}
