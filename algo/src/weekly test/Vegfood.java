/**
 * @author trinapal
 */
public class Vegfood implements DecorationPatternInterface{


    @Override
    public double foodPrice() {
        return 50.0;
    }

    @Override
    public String foodChoice() {
        return "Veg kebab";
    }
}
