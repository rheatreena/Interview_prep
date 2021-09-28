import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author trinapal
 */
public class StreamTest {

    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
        List<Student> students = Arrays.asList(student1, student2, student3);


        //Get student with exact match name "jayesh"

        Optional<Student> getStudent = students.stream().filter(s -> s.getName().equals("jayesh")).findFirst();

        System.out.println(getStudent.isPresent() ? getStudent.get() : "No Students");

        //Get student with matching address "1235"

        Optional<Student> getStudentAddress = students.stream().filter(s-> s.getAddress().getZipcode().equals("1235")).findFirst();

        System.out.println(getStudentAddress.isPresent()? getStudentAddress.get(): "No such student is present");

        //Get all student having mobile numbers 3333.

        List<Student> getAllstudent = students.stream().filter(s -> s.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333"))).collect(Collectors.toList());


        String studentName = getAllstudent.stream().map(name -> name.getName()).collect(Collectors.joining(","));
        System.out.print(studentName);

        //Get all student having mobile number 1233 and 1234

        List<Student> getAllValidStudents = students.stream().filter(x -> x.getMobileNumbers().stream().allMatch(m -> Objects.equals(m.getNumber(), "1233") || Objects.equals(m.getNumber(),"1234"))).collect(Collectors.toList());
        String validStudent = getAllValidStudents.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.print(" valid" + validStudent);

        //Create a List<Student> from the List<TempStudent>
        TempStudent tempStudent1 = new TempStudent("Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        TempStudent tempStudent2 = new TempStudent("Khyati",
            20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
        TempStudent tempStudent3 = new TempStudent("Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));


        List<TempStudent> allTemp = Arrays.asList(tempStudent1,tempStudent2,tempStudent3);
        List<Student> studentInfo = allTemp.stream().map(tempStudent -> new Student(tempStudent.name, tempStudent.age, tempStudent.address, tempStudent.mobileNumbers)).collect(Collectors.toList());

        studentInfo.forEach(System.out::println);

        //Convert List<Student> to List<String> of student name

       String allName = students.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]"));

       System.out.println(allName);

       //Convert List<students> to String

        List<String> studentNameList = students.stream().map(Student::getName).collect(Collectors.toList());
        String studentAllName = studentNameList.stream().collect(Collectors.joining(","));

        //Change the case of List<String>

        studentNameList.stream().map(String::toUpperCase).collect(Collectors.toList());

        //Sort List<String>

        studentNameList.stream().sorted().forEach(System.out::println);

        //Conditionally apply Filter condition, say if flag is enabled then.

        boolean sortConditionFlag = true;

        Stream<Student> conditionalFilterResult = students.stream()
                .filter(std -> std.getName().startsWith("J"));

        if(sortConditionFlag){
            conditionalFilterResult = conditionalFilterResult.sorted(Comparator.comparing(Student::getName));
        }

        System.out.println("Before sorting :");
        students.forEach(s -> System.out.println(s.getName()));
        List<Student> list = conditionalFilterResult.collect(Collectors.toList());
        System.out.println("After filter and conditional sorting :");
        list.forEach(s -> System.out.println(s.getName()));



    }

    //calculateAverage
   /* public double calculateAverage(List<Employee> employeeList) {

        employeeList.stream().mapToInt(employee -> employee.getSalary()).average().getAsDouble();
    }


    //Obtain a list of products belongs to category “Books” with price > 100

    List<Object> product = Product.findRepo().stream().filter(p -> p.getCategory().equalIgnorecase("books")).filter(p -> p.price() > 100).collect(Collectors.toList()); */
}
