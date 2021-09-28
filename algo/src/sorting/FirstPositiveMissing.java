import java.util.Arrays;

class FirstPositiveMissing {
    public static void main(String[] args) {
        int arr [] = {7,8,9,11,12};

        //printing(arr);
        System.out.print("  end "+ firstMissingPositive(arr));
    }

    private static void printing(int[] arr) {
        for(int i =0; i<arr.length; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }

    public static int firstMissingPositive(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        
        for(int i =0; i< nums.length; i++){
            if(nums[i] >= 0) {
                System.out.println(" " + nums[i] + " " + (nums[i] + 1));
                if ((nums[i] + 1) != nums[i + 1]) {
                    return (nums[i] + 1);
                }
            }
        }
        
        return nums.length;
    }
}