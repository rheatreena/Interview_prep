import java.util.Arrays;

/**
 * @author trinapal
 */
public class MissingNumber {
    public static void main(String[] args) {
        int [] nums = {3,1,0};
        Arrays.sort(nums);

       System.out.print(solution(nums));
    }

    private static int solution(int[] nums) {
        /*int i =0;
        while(i< nums.length){
            int correctIndex = nums[i];
            if(nums[i]< nums.length && nums[i] !=nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex]=temp;
            }else{
                i++;
            }
        }

        //search

        for(int index =0; index<nums.length; index++){
            if(nums[index] != index){
                return index;
            }
        } */

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == i + 1) {
                return i;
            }
        }

        return nums.length;
    }


}
