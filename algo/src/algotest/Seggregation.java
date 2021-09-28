/**
 * @author trinapal
 *
 * similar problem Binary Array Sorting
 */
public class Seggregation {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = {0, 0, 1, 1, 0};
        int result [] =  segregate0and1(arr, N);
        for(int i =0; i<result.length; i++){
            System.out.print(" " + result[i] + " ");
        }
    }

    static int[] segregate0and1(int[] arr, int n) {
        // code here
        int count = 0;

        for(int m =0,k=0,i=0; m<n;m++ ){
            if (arr[m] == 0) {
               count++;

            }
        }
// loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
            arr[i] = 0;

        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
            arr[i] = 1;

        return arr;

    }
}
