/**
 * @author trinapal
 */
public class RealService implements OfficeInternet{

    private String employeeName;

    RealService(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    public void grantAccess() {
        System.out.print("via real network");
    }
}
