/**
 * @author trinapal
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};
        sort(arr, arr.length);
        printArray(arr);
    }

    private static void sort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1; //previous one
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}