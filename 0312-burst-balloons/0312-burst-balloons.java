class Solution {
    public static int func(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost = arr[i-1]*arr[ind]*arr[j+1]+func(i,ind-1,arr,dp)+func(ind+1,j,arr,dp);
            if(maxi<cost) maxi=cost;
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] arr = new int[N+2];
        arr[0]=1;
        arr[N+1]=1;
        for(int i=0;i<N;i++){
            arr[i+1]=nums[i];
        }
        int[][] dp = new int[N+2][N+2];
        for(int i=0;i<N+2;i++){
            for(int j=0;j<N+2;j++){
                dp[i][j]=-1;
            }
        }
        return func(1,N,arr,dp);
    }
}