class CountedVowels {


    public static void main(String[] args) {
        System.out.println(countVowelStrings(33));
    }
    public static int countVowelStrings(int n) {
        
        if (n ==0){
            return 0;
        
        }
        int [] [] dp = new int[n+1][5+1];
        for(int i =0; i<6;i++){
            dp[0][i] = 1;
        }
        
        for(int i =1; i<n+1;i++){
            for(int j = 1; j <6; j++ ){
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        
        return dp[n][5];
    }
}