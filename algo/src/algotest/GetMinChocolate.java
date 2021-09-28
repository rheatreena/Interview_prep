/**
 * @author trinapal
 */
public class GetMinChocolate {

    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 6, 9};
        int n = arr.length;
       System.out.println(chocolates(arr, n));

    }

    // Function for finding maximum and value pair
    public static int chocolates(int arr[], int n) {
        int start=0, end = n-1;
        while(start < end){
            if(arr[start]<arr[end]){
                end--;
            }else{
                start++;
            }
        }
        return arr[start];
    }
}
