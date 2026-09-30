class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        long dp[][] = new long[n+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=0;
            }
        }
        dp[n][0]=0; dp[n][1]=0;
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                long profit = 0;
                if(buy==1) profit = Math.max(-prices[idx]+dp[idx+1][0],dp[idx+1][1]);
                else profit = Math.max(prices[idx]-fee+dp[idx+1][1],dp[idx+1][0]);
                dp[idx][buy]=profit;
            }
        }
        return (int)dp[0][1];
    }
}