class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                dp[i][j]=0;
            }
        }
        for(int ind=n-1;ind>=0;ind--){
            for(int prevInd=ind-1;prevInd>=-1;prevInd--){
                int len = 0+dp[ind+1][prevInd+1]; //not take
                if(prevInd==-1||nums[ind]>nums[prevInd]){
                    len=Math.max(len,1+dp[ind+1][ind+1]);
                }
                dp[ind][prevInd+1]=len;
            }
        }
        return dp[0][0];
    }
}