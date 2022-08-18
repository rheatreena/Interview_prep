/**
 * @author trinapal
 */
public class TwoEggDrop {

    public static void main(String[] args) {
        int floors = 100;
        int eggs = 2;
        int [][] dp = new int[floors +1][eggs+1];

        System.out.println(eggDrop(floors, eggs, dp));
    }

    private static int eggDrop(int floors, int eggs, int [][] dp) {
       /* if(floors<=2 || eggs == 1){
            return floors;
        }
        if(dp[floors][eggs] != 0)
            return dp[floors][eggs];

        int min = floors;

        for(int i =1; i<floors;i++){
            int brokenEggs = 1+ eggDrop(i-1, eggs-1, dp); // if one egg is broken
            //if egg is not broken

            int reducedFloor = 1+ eggDrop(floors-i, eggs, dp);

            // get max tries
            int maxTries = Math.max(brokenEggs, reducedFloor);
            min = Math.min(min,maxTries);
        }
        return dp[floors][eggs] = min; */

        int dp1 =0;

        for(int i =1;i<=floors;i++){
            // ig egg breaks, then move i-1, otherwise moves dp[i-1]
            dp1 = 1+i-1+dp1;

            if(dp1>=floors){
                return i;
            }

        }

return 0;

    }
}
