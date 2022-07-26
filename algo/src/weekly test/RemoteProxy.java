/**
 * @author trinapal
 */
public class RemoteProxy implements OfficeInternet{

    private String employeeName;

    RemoteProxy(String employeeName){
        this.employeeName = employeeName;
    }
    @Override
    public void grantAccess() {
        System.out.print(" via RemoteProxy");

        if(employeeName == "Trina"){
            RealService accessRealService = new RealService(employeeName);
            accessRealService.grantAccess();
        }else{
            System.out.print("Not Valid");
        }

    }
}
