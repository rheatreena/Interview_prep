/**
 * @author trinapal
 */
public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChangePolicy(coins, amount));
    }

    private static int coinChangePolicy(int[] coins, int amount) {
        if (amount ==0)
            return 0;

        //initialize a matrix
        int [][] table = new int[coins.length+1][amount+1]; // row =4, col = 12
         //fil up the table with 0;

        for(int i =0; i< coins.length + 1; i++){
            table[i][0] = 0;
        }

        for(int i =0; i< amount+1; i++){
            table[0][i] = Integer.MAX_VALUE;
        }

        //search

        for (int i=1; i<coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                if(j >= coins[i-1]) {
                    table[i][j] = Math.min(table[i-1][j], ((table[i][j-coins[i-1]] == Integer.MAX_VALUE)?0:1)+table[i][j-coins[i-1]]);
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }
            // getting the answer...
            int ans = table[table.length-1][table[0].length-1];
            // validating answer for anomalies..
            return (Math.abs(ans)==Integer.MAX_VALUE || ans==0 )?-1:ans;
        }

}
