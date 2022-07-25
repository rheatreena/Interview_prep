/**
 * @author trinapal
 */
public class ShellSortTest {
    // specific version of insertion sort. In insertion sort , we only move the element in one position ahead but in shell sort , we can divide the space.
    // good for large array

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};
        ShellSortTest sortTest = new ShellSortTest();
        sortTest.sort(arr);
        printSort(arr);
    }

    private void sort(int[] arr) {

        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            System.out.println(" first gap " + gap + "\n");
            for (int i = gap; i < length; i++) {
                System.out.println(" i " + i + "\n");
                int temp = arr[i];
                System.out.println(" temp " + temp +  " and gap " + gap+ "\n");
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    System.out.println(" arr[j - gap] " + arr[j - gap]  + "\n");
                    arr[j] = arr[j - gap];

                    System.out.println(" arr[j] " + arr[j]  + "\n");
                }
                arr[j] = temp;

                System.out.println(" finally arr[j] " + arr[j]  + "\n");
            }
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        }
        System.out.println("_________________________________________________");
    }
    private static void printSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}

