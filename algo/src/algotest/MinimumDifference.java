import java.util.Arrays;

/**
 * @author trinapal
 */
public class MinimumDifference {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 3, 19, 18, 25};
        System.out.print("difference " + minimum_difference(arr));

    }

        public static int minimum_difference(int[] nums)
        {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            for ( int i =0; i<nums.length; i++){
                if(i > 0){
                    if(nums[i]-nums[i-1] < diff){
                        diff = nums[i]-nums[i-1];
                    }
                }
            }
            return diff;
        }

}
