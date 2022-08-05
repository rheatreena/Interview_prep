class MinClimb {

    public static void main(String[] args) {
        System.out.print(minCostClimbingStairs(new int[]{10,15,20,10}));
    }
    public static int minCostClimbingStairs(int[] cost) {
        
        int numberOfStairs = cost.length;
        int [] dp = new int[numberOfStairs +1];
        
        dp[0] =cost[0];
        dp[1] = cost[1];
        
        for(int i =2; i<numberOfStairs; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            
        }
        return Math.min(dp[numberOfStairs - 1], dp[numberOfStairs -2]);
    }
}