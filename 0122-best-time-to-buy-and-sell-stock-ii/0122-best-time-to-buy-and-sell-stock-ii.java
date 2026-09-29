class Solution {
    public long func(int idx, int buy, int[] prices, int n, long[][] dp){
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        long profit = 0;
        if(buy==1) profit = Math.max(-prices[idx]+func(idx+1,0,prices,n,dp),func(idx+1,1,prices,n,dp));
        else profit = Math.max(prices[idx]+func(idx+1,1,prices,n,dp),func(idx+1,0,prices,n,dp));
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        long dp[][] = new long[n+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return (int)func(0,1,prices,n,dp);
    }
}