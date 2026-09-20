class Solution {
    public int perfectSum(int[] arr, int target) {
            int n = arr.length;
            int[][] dp = new int[n][target+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<=target;j++){
                    dp[i][j]=0;
                }
            }
            if(arr[0] == 0) {
                dp[0][0] = 2;
            } else {
                dp[0][0] = 1;

                if(arr[0] <= target) {
                    dp[0][arr[0]] = 1;
                }
            }
            for(int ind=1;ind<n;ind++){
                for(int sum=0;sum<=target;sum++){
                    int notTake = dp[ind-1][sum];
                    int take = 0;
                    if(arr[ind]<=sum) take = dp[ind-1][sum-arr[ind]];
                    dp[ind][sum]=take+notTake;
                }
            }
            return dp[n-1][target];
        }
    public int countPartitions(int[] arr, int diff) {
        int totSum=0;
        for(int i:arr) totSum+=i;
        if((totSum-diff)<0 || ((totSum-diff)%2)!=0) return 0;
        return perfectSum(arr,(totSum-diff)/2);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums,target);
    }
}