/**
 * @author trinapal
 */
public class XORAdditon {


    public static void main(String[] args) {

        int arr[ ] = {10, 11, 1, 2, 3};
        game_with_number(arr, arr.length);

    }
    public static int[] game_with_number (int arr[], int n) {
        // Complete the function

        // array to store the original
        // elements
        int elements[] = new int[n];
        System.out.println("arrays last element " +  arr[n-1]);
        // first element a i.e elements[0]=a
        for (int i = 0; i < n-1; i++) {

            elements[i] = arr[i] ^ arr[i+1];
        }
        int length = elements.length;
        elements[length -1] = arr[n-1];

        for (int i =0; i<n; i++){
            System.out.println("print element " + elements[i]);
        }
        return elements;
    }
}
