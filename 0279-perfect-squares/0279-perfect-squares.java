class Solution {
    public int func(int n, int[] dp){
        if(n==0) return 0;
        int minCount = Integer.MAX_VALUE;
        if(dp[n]!=-1) return dp[n];
        for(int i=1;i*i<=n;i++){
            int result = 1 + func(n-i*i,dp);
            minCount = Math.min(minCount, result);
        }
        return dp[n]=minCount;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
}