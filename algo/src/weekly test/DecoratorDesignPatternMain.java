import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 * @author trinapal
 */
public class DecoratorDesignPatternMain {
    private static int choice;
    public static void main(String[] args) throws IOException {
        do{
            System.out.print("========= Food Menu ============ \n");
            System.out.print("            1. Vegetarian Food.   \n");
            System.out.print("            2. Non-Vegetarian Food.\n");
            System.out.print("            3. Chineese Food.         \n");
            System.out.print("            4. Exit                        \n");
            System.out.print("Enter your choice: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(bufferedReader.readLine());

            switch(choice){
                case 1:
                    Vegfood vegfood = new Vegfood();
                    System.out.println(vegfood.foodChoice());
                    System.out.println( vegfood.foodPrice());
                    break;
                case 2:
                    DecorationPatternInterface nonVegFood = new NonVeg(new Vegfood());
                    System.out.println(nonVegFood.foodChoice());
                    System.out.println( nonVegFood.foodPrice());
                    break;
                case 3:
                    DecorationPatternInterface chinese = new ChineseFood((DecorationPatternInterface) new Vegfood());
                    System.out.println(chinese.foodChoice());
                    System.out.println( chinese.foodPrice());
                    break;
                default:{
                    System.out.println("Other than these no food available");
                }
                return;
            }
        }
        while(choice!=4);


    }
}
