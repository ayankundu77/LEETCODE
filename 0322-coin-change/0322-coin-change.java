class Solution {
    public int func(int ind, int amount, int[] coins, int[][] dp){
        if(ind==0){
            if(amount % coins[ind]==0){
                return amount/coins[ind];
            }else{
                return (int)1e9;
            }
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notTake = 0 + func(ind-1,amount,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amount) take = 1 + func(ind,amount-coins[ind],coins,dp);

        return dp[ind][amount] = Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return func(n-1,amount,coins,dp)>= (int)1e9 ? -1 : func(n-1,amount,coins,dp);
    }
}