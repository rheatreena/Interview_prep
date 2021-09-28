/**
 * @author trinapal
 */
public class ConcatArrToWave {

    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,2,3,4,5};
        convertToWave(arr, n);

    }

    public static void convertToWave(int arr[], int n){
        //if array size is even;
        if(n%2 == 0) {
            for(int i =0; i<n-1;){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i= i+2;
            }
        }
        else{

            for(int i =0; i<n-2;){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i = i+2;
            }

        }
        for (int i =0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
