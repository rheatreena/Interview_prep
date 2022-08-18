/**
 * @author trinapal
 */
public class NonVeg extends FoodDecorator{

    NonVeg(DecorationPatternInterface decorationPatternInterface) {
        super(decorationPatternInterface);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() +130;
    }

    @Override
    public String foodChoice() {
        return super.foodChoice() +"Nonveg kebab";
    }
}
