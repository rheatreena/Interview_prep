package practiceLambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest_aug {

    private int age;
    private String name;

    LambdaTest_aug(String name, int age) {
        this.name = name;
        this.age = age;
    }


    private static class BookStore{
        private String book;
        private double price;

        private String category;

        BookStore(String book, double price, String category ){
            this.book = book;
            this.price = price;
            this.category = category;

        }
    }
    public static void main(String[] args) {
        //adding elements in array
        addElements();
    }

    static void addElements() {
        LambdaTest_aug[] test = {new LambdaTest_aug("Trina", 33),
                new LambdaTest_aug("abhishek", 38),
                new LambdaTest_aug("Thiya", 5)
        };

        Stream<LambdaTest_aug> getValue = Stream.of(test);

        System.out.println("  " + getValue); // expected hashcode

        getValue.map(each -> each.age).filter(age -> age > 30).
                forEach(System.out::println);

        // another method
        Stream<LambdaTest_aug> anotherGetValue = Stream.of(new LambdaTest_aug("Trina", 33),
                new LambdaTest_aug("abhishek", 38),
                new LambdaTest_aug("Thiya", 5));

        anotherGetValue.map(each -> each.name).filter(name -> name.startsWith("T")).map(name -> name.toUpperCase()).
                forEach(System.out::println);

        Arrays.stream(test).filter(each -> each.age > 30).collect(Collectors.toList()).forEach(System.out::println);


        //flatmap

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));


        namesNested.stream().flatMap(each -> each.stream()).forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        namesNested.stream().flatMap(Collection::stream).forEach(System.out::println);


        LambdaTest_aug[] arrayOfEmps = {
                new LambdaTest_aug("Jeff Bezos", 100000),
                new LambdaTest_aug("Bill Gates", 200000),
                new LambdaTest_aug("Mark Zuckerberg", 300000)

        };

        Stream.of(arrayOfEmps).map(each -> each.age + 10).peek(System.out::println).collect(Collectors.toList());


        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(".........." +  collect);
        //sorting

        List<LambdaTest_aug> details = Arrays.stream(arrayOfEmps).sorted(Comparator.comparing(e -> e.name)).collect(Collectors.toList());
        System.out.println("..........details ...." +  details);


        //create   a book list  with price

        BookStore [] bookList = { new BookStore("ABC", 30.5, "kids"),
                new BookStore("numbers", 50.8, "kids"),
                new BookStore("Geometry", 150.8, "young adult")
        };

        List<BookStore> bookStoreList = Arrays.asList( new BookStore("ABC", 30.5, "kids"),
                new BookStore("numbers", 50.8, "kids"),
                new BookStore("Geometry", 150.8, "young adult"));


        // filter the books which are less than $100
        System.out.println(".............................................................");
        bookStoreList.stream().map(each -> each.price).filter(each -> each <100).forEach(System.out::println);


        //Obtain a list of order with products belong to category “kids”
        bookStoreList.stream().filter(each -> each.category.equals("kids")).map(each -> each.book).peek(System.out::println).collect(Collectors.toList());
        System.out.println(".............................................................");

        //Obtain a list of product with category = “Kids” and then apply 10% discount
        bookStoreList.stream().filter(each -> each.category.equals("kids")).map(each -> (each.price*0.9)).peek(System.out::println).collect(Collectors.toList());
        System.out.println(".............................................................");

        //Get the cheapest products of “kids” category

       System.out.println(bookStoreList.stream().filter(each -> each.category.equals("kids")).sorted(Comparator.comparing(e1 -> e1.price)).findFirst().get().book);
     //another way
        System.out.println(bookStoreList.stream().filter(each -> each.category.equals("kids")).min(Comparator.comparing(e1 -> e1.price)).get().book);
        System.out.println(".............................................................");

        //total sum of kids book
        System.out.println(bookStoreList.stream().filter(each -> each.category.equals("kids")).mapToDouble(each -> each.price).sum());
        System.out.println(".............................................................");

        // predicate
        Predicate<String> startsWithA = (n) -> n.startsWith("A");

        bookStoreList.stream().filter(each -> startsWithA.test(each.book)).map(each -> each.book).peek(System.out::println).collect(Collectors.toList());

        System.out.println(".............................................................");

        // // Applying 12% VAT on each purchase - reduce

        System.out.println(" reduce operation ::: " + bookStoreList.stream()
                .filter(each -> each.category.equals("kids"))
                .map(each -> each.price + each.price*.12)
                .reduce((sum, cost) -> sum +cost).get());

        System.out.println(".............................................................");

        //List to String in uppercase

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String countries = G7.stream().map(each -> each.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(" countries :: " + countries);

        //Runnable

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i< 5; i++){
                    System.out.println(" before java 8  attempt " + i);
                }
            }
        }).start();

        System.out.println(".............................................................");

        //after java 8
        new Thread(() -> {
            for(int i = 0 ; i<5; i++){
                System.out.println("after java 8 " + i);
            }
        }).start();

        System.out.println(".............................................................");

    }
}
