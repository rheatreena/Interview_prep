class MaxNumberGenerated {

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }
    public static int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        int [] nums = new int[n+1];
        nums[0] =0;
        nums[1] = 1;
        int max = 1;
        for(int i =2; i<n+1;i++){
            if(i%2==0){
            nums[i] = nums[i/2];
            }else{
                nums[i] = nums[(i+1)/2] +nums[i/2];
            }
            
            if(max<nums[i]){
               max = nums[i];
            }
        }
          
        return max;
    }
    
}