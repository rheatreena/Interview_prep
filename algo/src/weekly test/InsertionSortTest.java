/**
 * @author trinapal
 */
public class InsertionSortTest
{
    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};
        InsertionSortTest sortTest = new InsertionSortTest();
        sortTest.sort(arr);
        printSort(arr);
    }

    private static void printSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public void sort(int [] arr){
        int size = arr.length;

        //take the second element onwards and compare with the left elements
        for(int i =1; i< size; i++){

            int key = arr[i];
            int target = i-1;
            while(target >= 0 && arr[target] > key){
                arr[target + 1] = arr[target];
                target = target - 1;
            }
            arr[target+1] = key;
        }
    }
}
