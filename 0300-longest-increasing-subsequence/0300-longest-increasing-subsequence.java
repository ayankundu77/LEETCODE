class Solution {
    public int func(int ind, int prevInd, int[] nums, int n, int[][] dp){
        if(ind==n) return 0;
        if(dp[ind][prevInd+1]!=-1) return dp[ind][prevInd+1];
        int len = 0+func(ind+1,prevInd,nums,n,dp); //not take
        if(prevInd==-1||nums[ind]>nums[prevInd]){
            len=Math.max(len,1+func(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prevInd+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                dp[i][j]=-1;
            }
        }
        return func(0,-1,nums,n,dp);
    }
}