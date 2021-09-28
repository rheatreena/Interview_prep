import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author trinapal
 */
public class MainTest {

    public static void main(String[] args) {
         Wishing wish = new Wishing();
         wish.wish(() ->  System.out.println("welcome" ));

         wish.getProduct((a, b) -> a*b );

         //stream test

        int [] arr = {1,2,54,3,6,7};
        Stream<Integer> stream = Stream.of(1,2,54,3,6,7);
        stream.forEach(p -> System.out.println(p));


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(23);
        list.add(45);
        list.add(6);
        // numbers greater than 10
        list.stream().filter(i -> i>10).forEach(System.out::println);



        List<String> list1 = new ArrayList<>();
        list1.add("Dave");
        list1.add("Joe");
        list1.add("Ryan");
        list1.add("Iyan");
        list1.add("Ray");

        //uppercase

        list1.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
