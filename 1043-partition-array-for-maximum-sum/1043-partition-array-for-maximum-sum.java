class Solution {
    public int func(int idx, int n, int[] arr, int k, int[] dp){
        if(idx==n) return 0;
        int len = 0, currSum = 0, maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        if(dp[idx]!=-1) return dp[idx];
        for(int j=idx;j<Math.min(n,idx+k);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            currSum=(len*maxi)+func(j+1,n,arr,k,dp);
            maxAns = Math.max(maxAns,currSum);
        }
        return dp[idx]=maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,arr,k,dp);
    }
}