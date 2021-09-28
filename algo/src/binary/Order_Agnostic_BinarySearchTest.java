/**
 * @author trinapal
 */
public class Order_Agnostic_BinarySearchTest {
    public static void main(String[] args) {
        int [] unordered_arr = {90,75,18,12,6,4,3,1};
        int target = 750;
        System.out.print(binarySearch(unordered_arr, target));
    }

    private static boolean binarySearch(int[] unordered_arr, int target) {

        //assume the array is sorted - but it can be either in ascending or descending order

        //checking last two elements

        int start = unordered_arr[0];
        int end = unordered_arr[unordered_arr.length -1];
        boolean isAsc = false;
        if(start > end){
            //descending order
            isAsc = false;
        }
        else if(start<end){
            isAsc = true;
            //ascending order


        }
        int newStart =0;
        int newEnd = unordered_arr.length  -1;
        while(newStart < newEnd){
            int mid = newStart + (newEnd -newStart)/2;
            if (unordered_arr[mid]== target){
                return true;
            }
            if(isAsc){
                if(target > unordered_arr[mid]){
                    newStart = mid + 1;
                }
                else if(target < unordered_arr[mid]){
                    newEnd = mid -1;
                }
            }else{
                if(target > unordered_arr[mid]){
                    newEnd = mid - 1;
                }
                else if(target < unordered_arr[mid]){
                    newStart = mid + 1;
                }
            }

        }
    return false;
    }
}
