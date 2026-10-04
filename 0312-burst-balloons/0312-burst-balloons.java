class Solution {
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
                dp[i][j]=0;
            }
        }
		for(int i=N+1;i>=1;i--){
			for(int j=1;j<N+1;j++){
                if(i>j) continue;
				int mini = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    if(mini<cost) mini=cost;
                }
                dp[i][j] = mini;
			}
		}
		return dp[1][N];
    }
}