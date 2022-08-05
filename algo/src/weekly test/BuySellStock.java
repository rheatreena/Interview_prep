class BuySellStock {
    public static void main(String[] args) {
        int prices [] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        //int [] dp = new int[prices.length+1];
        
        if(prices.length < 2){
            return 0;
        }
        
        int min=prices[0]; 
        int result=0;
        for(int i =1; i<prices.length; i++){
           result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
}