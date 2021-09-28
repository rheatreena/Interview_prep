import java.util.ArrayList;

/**
 * @author trinapal
 */
public class ArrayManipulation {
    public static void main(String[] args) {

        int arr[][] = {{1,2}, {1, 2}};
        int n =2;
        int barr[] = {10,1};
        ArrayList<Integer> output = array(arr, barr, n);
        for(int i =0; i<output.size();i++){
            System.out.println("print value " + output.get(i));
        }
    }
    public static ArrayList<Integer> array(int a[][], int b[], int n)
    {
        // get the maximum value of 1-d array
        ArrayList<Integer> output = new ArrayList<Integer>();
        int max = b[0];
        for(int i =0; i<= b.length-1; i++){
            if(b[i] > max) {
                max = b[i];
            }
        }

        // left diagnoal sum of 2d- array

        /*
        1 2 3
        4 5 6
        7 8 9
        */
        int sum = 0;
        for(int i =0; i<=n-1; i++){
            sum+=a[i][i];
        }
        output.add(sum);
        output.add(max);


        return output;

    }
}
