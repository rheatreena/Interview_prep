/**
 * @author trinapal
 */
public class SumElementArray {
    public static void main(String[] args) {

        int n = 3;
        int arr[] = {3,2,1};
        System.out.print(sumElement(arr,n));
    }
    public static int sumElement(int arr[], int n)
    {
        int sum =0;
        for(int i =0; i<n ;i++){
            sum+= arr[i];
        }
        return sum;
    }
}
