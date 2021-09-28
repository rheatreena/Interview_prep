/**
 * @author trinapal
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        int high =n -1;
        quickSortprocess(arr, 0, high);
        printArray(arr, n);
    }

    private static void printArray(int[] arr, int n) {
        for(int i =0; i<n; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }
    private static void quickSortprocess(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);

            quickSortprocess(arr, low, pivot -1);
            quickSortprocess(arr, pivot +1, high);
        }

        // the right side of pivot would be higher than the left side
    }

    private static int partition(int[] arr, int low, int high) {
        // make higher index the pivot
        int pivot = arr[high];
        int i = (low -1);

        for(int j = low; j<=arr.length -1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return  (i+1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
}
