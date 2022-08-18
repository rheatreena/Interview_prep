/**
 * @author trinapal
 */
public class ChineseFood extends FoodDecorator{


    ChineseFood(DecorationPatternInterface decorationPatternInterface) {
        super(decorationPatternInterface);
    }

    @Override
    public double foodPrice() {
        return 80.7;
    }

    @Override
    public String foodChoice() {
        return "Chinese kebab";
    }
}
