package facade;

/**
 * @author trinapal
 */
public class ShopKeeper {

    //create instance of every phone

    private Mobileshop samsung;
    private Mobileshop vivo;
    private Mobileshop iphone;

    ShopKeeper(){
        samsung = new Samsung();
        vivo = new Vivo();
        iphone = new Iphone();
    }

    //methods to access phones
    public void iphoneSale(){
        iphone.mobileNo();
        iphone.price();
    }


    public void samsungSale(){
        samsung.mobileNo();
        samsung.price();
    }

    public void vivoSale(){
        vivo.mobileNo();
        vivo.price();
    }

}
