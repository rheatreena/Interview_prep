/**
 * @author trinapal
 */
abstract public class FoodDecorator implements DecorationPatternInterface{

    private DecorationPatternInterface decorationPatternInterface; //composition

    FoodDecorator(DecorationPatternInterface decorationPatternInterface){
        this.decorationPatternInterface = decorationPatternInterface;
    }


    @Override
    public double foodPrice() {
        return decorationPatternInterface.foodPrice();
    }

    @Override
    public String foodChoice() {
        return decorationPatternInterface.foodChoice();
    }
}
