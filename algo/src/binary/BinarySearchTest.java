/**
 * @author trinapal
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int arr[] ={1,4, 6, 7, 9,56};
        int target = 7;
        int start =0;
        int end = arr.length -1;
        System.out.print(search(arr, target, start, end));
    }

    private static boolean  search(int[] arr, int target, int start, int end) {
        while(start <= target){
            int midPoint = start+(end-start)/2;

            if(arr[midPoint] == target){
                return true;
            }
            else if(target > arr[midPoint] ){
               start =  midPoint+1;
                //start++;
            }
            else if(target < arr[midPoint]){
                end = midPoint-1;
               // end--;
            }
        }
        return false;
    }
}
