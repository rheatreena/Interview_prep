import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author trinapal
 */
public class TransientUse implements Serializable {

     int i =30;
     transient String j ="40_age";
     transient int k =50;
     transient static final int l =60;
     transient static int m = 70;
     transient final int n = 80;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
         TransientUse transientUse = new TransientUse();
         //get absolute path

         //write
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(transientUse);

        //read
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        TransientUse readTransientUse = (TransientUse) objectInputStream.readObject();
        System.out.println(" " + readTransientUse);
        System.out.println("i " + readTransientUse.i);
        System.out.println("j " + readTransientUse.j);
        System.out.println("k " + readTransientUse.k);
        System.out.println("l " + readTransientUse.l);
        System.out.println("m " + readTransientUse.m);
        System.out.println("n " + readTransientUse.n);


    }
}
