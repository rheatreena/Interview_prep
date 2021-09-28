/**
 * @author trinapal
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        sort(arr, n);
        printArray(arr, n);
    }

    private static void printArray(int[] arr, int n) {
        for(int i =0; i<arr.length; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }

    private static void sort(int[] arr, int n) {
        for(int i =0; i<n-1 ; i++){
            for(int j =0; j< n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
    }
}
