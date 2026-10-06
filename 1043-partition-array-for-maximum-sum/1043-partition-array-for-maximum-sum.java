class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[n]=0;
        for(int idx = n-1;idx>=0;idx--){
            int len = 0, currSum = 0, maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for(int j=idx;j<Math.min(n,idx+k);j++){
                len++;
                maxi = Math.max(maxi,arr[j]);
                currSum=(len*maxi)+dp[j+1];
                maxAns = Math.max(maxAns,currSum);
            }
            dp[idx]=maxAns;
        }
        return dp[0];
    }
}