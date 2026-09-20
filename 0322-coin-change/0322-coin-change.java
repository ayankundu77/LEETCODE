class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=0;
            }
        }
        for(int t=0;t<=amount;t++){
            if(t % coins[0]==0) dp[0][t]=t/coins[0];
            else dp[0][t]=(int)1e9;
        }

        for(int ind=1;ind<n;ind++){
            for(int t=0;t<=amount;t++){
                int notTake = 0 + dp[ind-1][t];
                int take = Integer.MAX_VALUE;
                if(coins[ind]<=t) take = 1 + dp[ind][t-coins[ind]];
                dp[ind][t] = Math.min(take,notTake);
            }
        }
        return dp[n-1][amount]>= (int)1e9 ? -1 : dp[n-1][amount];
    }
}