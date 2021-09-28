/**
 * @author trinapal
 */
public class Multiply {
    public static void main(String[] args) {
       int arr[] = {4,5,6};
       System.out.print(multiply(arr, arr.length));
    }

    public static int multiply (int[] arr, int n) {
        //Complete the function
        //Taking care of odd and even
        int firstSum =0;
        int secondSum =0;
        int result = 0;
        if(n%2 ==0){
            //upper half
            for(int i =0; i<n/2; i++){
                firstSum+=arr[i];
            }
            //second part
            for(int i = n/2; i<n;i++){
                secondSum+= arr[i];
            }
        }else{
            //upper half
            for(int i =0; i<(n-1)/2; i++){
                firstSum+=arr[i];
            }
            //second part
            System.out.println("hello " + n+ "hey"+ ((n - 1)/2 +1));
            for(int i = ((n - 1)/2); i<n; i++){
                System.out.println(" " + i);
                secondSum+= arr[i];
            }
        }
        result = firstSum * secondSum;
        return result;
    }
}
