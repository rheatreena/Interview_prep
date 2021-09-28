/**
 * @author trinapal
 */
public class CyclicSort {


    public static void main(String[] args) {
        System.out.print("  hiiiii ");
        int arr[] ={3,2,1,5,4};
        sorting(arr, arr.length);
        printing(arr);
        System.out.print("  end ");
    }

    private static void printing(int[] arr) {
        for(int i =0; i<arr.length; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }

    private static void sorting(int[] arr, int length) {

        // check, swap, move

        /*for(int i =0; i<length-1; i++){
            if(i+1 != arr[i]){
                int temp = arr[i];
                arr[i+1]
            }
        }*/
        int i =0;
        while(i<length){
            int correctindex = arr[i]-1;
            if(arr[i] != arr[correctindex]){ //check
                int temp = arr[i];
                arr[i] = arr[correctindex]; //swap
                arr[correctindex] =temp;
            }else{
                i++;
            }
        }
    }

}
