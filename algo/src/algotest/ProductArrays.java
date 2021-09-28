/**
 * @author trinapal
 */
public class ProductArrays {
    public static void main(String[] args) {
        int A[] = {-6 ,-3};
        int B[] = {-14,-1 ,18 ,8, -9 ,9, -11 ,-15, -18 ,-1 ,-8 ,-1 ,-18 ,3, -14, -6 ,-16 ,-18, -6, 3};
        System.out.println(find_multiplication(A, B, A.length, B.length));
    }
    public static long find_multiplication (int arr[], int brr[], int n, int m) {
        // Complete the Function
        int max =arr[0]; // should not initialize with 0 because it will not consider  negative values then
        int min = brr[0];
        int product = 0;
        for(int i =1; i<n; i++){

            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int i =1; i<m; i++){
            if(brr[i] < min){
                min = brr[i];
            }
        }

        product = max*min;
        long productInLong = Long.valueOf(product);
        return productInLong;
    }

}
