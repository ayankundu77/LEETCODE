class Solution {
    public long func(int idx, int buy, int[] prices, int maxT,int n, long[][][] dp){
        if(maxT==0) return 0;
        if(idx==n) return 0;
        if(dp[idx][buy][maxT]!=-1) return dp[idx][buy][maxT];
        long profit = 0;
        if(buy==1) profit = Math.max(-prices[idx]+func(idx+1,0,prices,maxT,n,dp),func(idx+1,1,prices,maxT,n,dp));
        else profit = Math.max(prices[idx]+func(idx+1,1,prices,maxT-1,n,dp),func(idx+1,0,prices,maxT,n,dp));
        return dp[idx][buy][maxT]=profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        long dp[][][] = new long[n+1][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return (int)func(0,1,prices,2,n,dp);
    }
}