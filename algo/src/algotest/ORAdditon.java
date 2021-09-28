/**
 * @author trinapal
 */
public class ORAdditon {
    public static void main(String[] args) {
        int arr[ ] = {10, 11, 1, 2, 3};
        game_with_number(arr, arr.length);
    }
        // Function for finding maximum and value pair
        public static int[] game_with_number (int arr[], int n) {
            int elements [] =  new int[n];

            for(int i =0; i<n-1; i++){

                elements[i] = arr[i] | arr[i+1];
            }

            elements[n -1] = arr[n-1];

        for (int i =0; i<=n-1; i++){
            System.out.println("print element "+ elements[i]);
        }
            return elements;
        }
    }

