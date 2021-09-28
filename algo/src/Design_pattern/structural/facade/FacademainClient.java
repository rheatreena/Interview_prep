package facade;

/**
 * @author trinapal
 */
public class FacademainClient {
    public static void main(String[] args) {
    ShopKeeper shopKeeper = new ShopKeeper();

    String choice = "Samsung";
    // if we forget "break, then it will print all the options
    switch (choice){
        case "Samsung":
            shopKeeper.samsungSale();
            break;
        case "Vivo":
            shopKeeper.vivoSale();
            break;
        case "IPhone":
            shopKeeper.iphoneSale();
            break;

    }

    }
}
