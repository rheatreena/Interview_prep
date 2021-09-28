/**
 * @author trinapal
 */
public class CeilingNumber {

    public static void main(String[] args) {
        int [] arr = {2,3,5,9,14,16,18};
        int target = 15;
        System.out.print(findCeiling(arr, target));
    }

    private static int  findCeiling(int[] arr, int target) {
        //ceiling meaning that number or smallest greater number than the target
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = start +(end - start)/2;

            if(arr[mid] == target){
                return arr[mid];
            }
            else if (target > arr[mid] ){
                start = mid +1;
            }
            else if (target < arr[mid] ){
                end = mid -1;
            }
        }
        //return nearest larger element
    return arr[start];
    }
}
