class Solution {
    public boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
        }
        if(totSum%2==1) return false;

        return subsetSumToK(nums.length,totSum/2,nums);
    }
}
    