import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author trinapal
 */

interface TestLambda{
    public void test();
   // public String walk();
}

@FunctionalInterface
interface TestReturnLambda{
    public String walk();
}

interface ParameterCheck{
    public String checkParameter(String param, int value);
}

interface ReverseString{
    public String reverse(String word);
}

@FunctionalInterface
interface GenericInterface<E>{
    E func(E e);
}
public class LambdaTest extends Thread{

    public static void main(String[] args) {
        //1. void
        TestLambda testing = () -> System.out.println("hi"); // only available for functional interface
        testing.test();

        //2. return type
        TestReturnLambda testReturnLambda = () -> {
            System.out.println("lambda walk");
            return "hiiiiii";
        } ;

        System.out.println(testReturnLambda.walk());

        //3. parameterized and multiple statement

        ParameterCheck parameterCheck = (param, value) ->{
            if (value > 100 && param == "String"){
                return String.format(" param %s is invalid ", param);
            } else if (value > 100 && param == "integer") {
                return String.format(" param %s is valid ", param);

            }else{
                return "value is too small";
            }
        };
        String result = parameterCheck.checkParameter("integer", 190);
        System.out.println(result);


        //4. for-each loop

        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(s -> System.out.println(" people name:: " +s));

        // 5. creating thread

        Runnable r = new Runnable() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("mm/dd/yy HH:mm:ss");
            LocalDateTime date =LocalDateTime.now();
            @Override
            public void run() {
                for(int i =0; i<10; i++){
                    System.out.println(" you should be awake " + dateTimeFormatter.format(date));
                    try {
                        Thread.sleep(2000); // need to modify
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        } ;

        Thread t1 = new Thread(r);
        t1.start();



        //6. comparator
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(34, "D", "java"));
        employeeList.add(new Employee(31, "B", "python"));
        employeeList.add(new Employee(30, "A", "java"));
        employeeList.add(new Employee(31, "D", "react"));

        for(Employee e: employeeList)
            System.out.println(" before sorting details ::  " +  e.name + " " + e.age);

        //sorting based on name
        Collections.sort(employeeList, Comparator.comparing(p -> p.name));
        //sorting based on age

        Collections.sort(employeeList , Comparator.comparing(a -> a.age));

        for(Employee e: employeeList)
            System.out.println(" details ::  " +  e.name + " age " + e.age);


         //7. using lambda to filter data

        List<Employee> filteredEmployee = employeeList.stream().filter(e -> e.age < 31).collect(Collectors.toList());

        for(Employee e: filteredEmployee)
            System.out.println(" filtered details ::  " +  e.name + " age " + e.age);


        //7. anonymous class

        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i =0; i<5; i++) {
                    System.out.println(" you should not be awake " );
                }
            }
        }).start();



         ReverseString reverseString = (test -> {
             StringBuilder sb = new StringBuilder();
             char [] testValue = test.toCharArray();
             for(int i = testValue.length-1; i>=0; i--){
                 sb.append(testValue[i]);
             }
             return sb.toString();
         });

         System.out.println(" reverse " + reverseString.reverse("hello"));

        //8. Generic interface
        GenericInterface genericInterface = ( test -> (double)test*(double) test);

        System.out.println(" generic interface " +  genericInterface.func(10.6));


        //9. stream
         List<String> filteredPlaces = getPlaces().stream().filter(p ->p.startsWith("Nepal")).map(place -> place.toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        filteredPlaces.forEach(place -> System.out.println(" filtered place ::: " + place));



    }

    static List<String> places = new ArrayList<>();

    public static List<String> getPlaces(){
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }


}

class Employee{
    int age;
    String name;
    String skill;

    Employee(int age, String name, String skill){
        this.age = age;
        this.name = name;
        this.skill = skill;
    }


}
