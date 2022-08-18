import java.util.Arrays;

/**
 * @author trinapal
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int result = 1;
        int [] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
        for(int i =0; i<nums.length;i++){
            for(int j= 0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}



