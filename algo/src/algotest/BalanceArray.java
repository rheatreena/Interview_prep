/**
 * @author trinapal
 */
public class BalanceArray {

    public static void main(String[] args) {
        int N = 4;
        long arr[] = {1, 5, 3, 2};
        System.out.println(minValueToBalance(arr, N));
    }
    static long minValueToBalance(long a[] ,int n)
    {
        //check if the array length is odd or even
        long difference = 0L;
        if(n%2 ==0){
            long first_total =0L;
            long second_total =0L;
            for(int i =0; i< n/2; i++){
                first_total += a[i];
            }
            int j = n-n/2;
            for(; j<n;j++){
                second_total+= a[j];
            }
            difference = second_total - first_total;

        }
        else{
            long first_total =0L;
            long second_total =0L;
            for(int i =0; i< (n-1)/2; i++){
                first_total+= a[i];
            }
            int j = n-(n-1)/2;
            for(; j<n;j++){
                second_total+= a[j];
            }
            difference = second_total - first_total;
        }
        long final_diff = Math.abs(difference);

        return final_diff;

    }
}
