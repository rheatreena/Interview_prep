import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * @author trinapal
 */
public class ReadAndWrite {
    static String fileLocation = "/Users/trinapal/Documents/test.txt";
    public static void main(String[] args) throws IOException {
       File file = new File(fileLocation);
       if (!file.exists()){
           file.createNewFile();
       }
        FileWriter fileWriter = new FileWriter(fileLocation);
       fileWriter.write("test");
       fileWriter.close();

       //read the file

        FileReader fileReader = new FileReader(fileLocation);
        int readCh = fileReader.read();
        while(readCh != -1) {
            System.out.print(" " + (char)readCh);
            readCh = fileReader.read();
        }
        fileReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line = reader.readLine();
        while(line !=  null){
           System.out.println(" " + line);
            line = reader.readLine();
        }

        FileInputStream fileInputStream = new FileInputStream(fileLocation);
        int data = fileInputStream.read();
        while(data != -1){
            System.out.print(" " + (char)data);
            data = fileInputStream.read();

        }


        List list = Files.readAllLines(Path.of(fileLocation));
        list.forEach(line1 -> System.out.print(" " + line1));

        // Read input from the console
        Scanner sc= new Scanner(System.in);
        String name = null;
        int age = 0;
        //while(sc != null){
            System.out.println(" Your name : " );
            name = sc.next();
            System.out.println("your age: ");
            age = sc.nextInt();
       // }
        System.out.print(String.format("Name is %s and age is %d", name,age));
       // sc.close();

    }
}
