import java.util.Arrays;

/**
 * @author trinapal
 */
public class RemoveLargestElements {
    public static void main(String[] args) {
        long N = 5;
        long arr[] = {2, 8, 7, 1, 5};
        /*long arr_test[] = findElements(arr, N);
        for(int i =0; i< arr_test.length; i++){
            System.out.print(" "+ arr_test[i] +" ");
        } */
        // another approach
        findLargest(arr, N);
    }

    private static void findLargest(long[] arr, long n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i =0; i<n; i++){

            // If current element is smaller
            // than first then update both
            // first and second
            if(arr[i] > first){
                second = first;
                first = (int) arr[i];
            }
            else if (arr[i] > second)
                second = (int) arr[i];
        }
        for (int i = 0; i < n; i++)
            if (arr[i] < second)
                System.out.print(arr[i] + " ") ;

    }

    public static long[] findElements( long a[], long n)
    {
        long new_arr [] = new long[(int)(n-2)];
        Arrays.sort(a);
        for(int i =0; i<n-2; i++){
            new_arr[i] = a[i];
        }
        return new_arr;

    }
}
