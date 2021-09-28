/**
 * @author trinapal
 */
public class Wishing  {
   /*@Override
    public void greet() {
        System.out.print("welcome");
    } */

    //lambda

    public void wish(Greeting greeting){
        greeting.greet();
    }

    public int getProduct(Calculator calculator){
        int j =9, i = 8;
        System.out.println("product " + calculator.product(i,j));
        return calculator.product(i,j);
    }
}
