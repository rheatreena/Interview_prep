/**
 * @author trinapal
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        int low =0; int high =n-1;
        mergeSortProcess(arr, low, high);

        printArray(arr, n);
    }

    private static void printArray(int[] arr, int n) {
        for(int i =0; i<n; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }

    static void mergeSortProcess(int arr[], int low, int high){

        //middle point

        if(low < high) {
            int mid = low + (high - low) / 2;

            mergeSortProcess(arr, low, mid);
            mergeSortProcess(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        //length of subArray 1 and subArray 2

        int n1 = mid -low +1;
        int n2 = high - mid;

        //create two temp array
        int new_sub_arr1 []  = new int[n1];
        int new_sub_arr2[] = new int[n2];

        //populate two temp arrays
        for(int i =0; i<n1; i++){
            new_sub_arr1[i] = arr[low +i];
        }
        for(int i =0; i<n2;i++){
            new_sub_arr2[i] = arr[mid +1 +i];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = low;

        while( i<n1 && j<n2){
            if(new_sub_arr1[i] <= new_sub_arr2[j]){
                arr[k] = new_sub_arr1[i];
                i++;
            }else{
                arr[k] = new_sub_arr2[j];
                j++;
            }
            k++;
        }
        while (i <n1){
            arr[k] = new_sub_arr1[i];
            i++;
            k++;

        }
        while (j <n2){
            arr[k] = new_sub_arr2[j];
            j++;
            k++;
        }
    }
}


