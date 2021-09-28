import java.util.HashMap;
import java.util.Map;

/**
 * @author trinapal
 */
public class Rearrange
{
    public static void main(String[] args) {
        int N = 5;
        long arr[] = {4,0,2,1,3};
        long[] result = arrange(arr, N);
        for(int i =0; i<result.length; i++){
            System.out.print(" " + result[i] + " ");
        }
    }
    static long [] arrange(long arr[], int n)
    {
        // your code here
        long new_arr [] = new long[n];
        Map<Integer, Long> map = new HashMap<>();
        /*for (int i =0; i<n; i++){
            if(arr[i] == i){
                new_arr[i] = arr[i];
            }else{
                map.put(i, arr[i]);
            }

        }*/
        /*for (int i =0; i<new_arr.length;i++){
            if(map.containsValue(i)){
                new_arr[i] == map.
            }
        }*/

        /*for(int i =0; i<arr.length;){
            if(arr[i] >= 0 & arr[i] != i){
                 int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            }
            else{
                i++;z
            }
        }*/
        return new_arr;
    }
}
