import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author trinapal
 */
public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 15, 25, 98, 32, 10, 8);

        /*
        Given a list of integers, find out all the even numbers exist in the list using Stream functions?
         */
        myList.stream().filter(s -> s % 2 == 0).forEach(System.out::print);
        System.out.println("\n" + "----------------");
        /*
        Given a list of integers, find out all the numbers starting with 1 using Stream functions?
         */
        myList.stream().map(s -> s + " ") // int to string
                .filter(s -> s.startsWith("1")).forEach(System.out::print);

        System.out.println("\n" + "----------------");
        /*
        How to find duplicate elements in a given integers list in java using Stream functions?
         */
        Set<Integer> list = new HashSet<>();
        myList.stream().filter(s -> !list.add(s)).forEach(System.out::println);

        System.out.println("\n" + "----------------");
        /*
        Given the list of integers, find the first element of the list using Stream functions?
         */

        myList.stream().findFirst().ifPresent(System.out::println);

        /*
        Given a list of integers, find the total number of elements present in the list using Stream functions?
         */

        System.out.println("\n" + "----------------");

        Long total = myList.stream().count();

        System.out.println(" count " + total);

        System.out.println("\n" + "----------------");

        /*
        Given a list of integers, find the maximum value element present in it using Stream functions?
         */
        myList.stream().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println("\n"+ "----------------");

    /*
    Given a String, find the first non-repeated character in it using Stream functions?

     */

        String input = "Java Hungry Blog Alive is Awesome";
        Character result = input.chars().mapToObj(s -> Character.valueOf((char) s)).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().
                filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst().get();
        System.out.println(result);


        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<input.toCharArray().length; i++){
            map.put(input.toCharArray()[i], map.getOrDefault(input.toCharArray()[i],0)+1);
            if(map.get(input.toCharArray()[i]) == 1){
                q.add(input.toCharArray()[i]);
            }


        }
        while(!q.isEmpty()){
            char c = q.peek();
            if (map.get(c) == 1){
                break;
            }
            else{
                q.remove();
            }
        }

        if(q.isEmpty()){
            System.out.println(" -1 ");
        }
        else{
            System.out.println(q.peek());
        }

        //time complexity o(n)


    /*
    Given a String, find the first repeated character in it using Stream functions
     */


    Character repeatedDigit = input.chars().mapToObj(s -> Character.valueOf((char) s)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).
            entrySet().stream().filter(s -> s.getValue() > 1L).map(s -> s.getKey()).findFirst().get();

    System.out.println("repeatedDigit "+repeatedDigit);

    /*
    Given a list of integers, sort all the values present in it using Stream functions?
     */
    myList.stream().sorted().forEach(System.out::println);

    /*
    Given a list of integers, sort all the values present in it in descending order using Stream functions?
     */

    myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

    }



}
