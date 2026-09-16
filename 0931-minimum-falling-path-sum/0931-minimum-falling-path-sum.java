class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int upLeft=(int)1e9, upRight=(int)1e9;
                int up = matrix[i][j]+dp[i-1][j];
                if(j-1>=0) upLeft = matrix[i][j]+dp[i-1][j-1];
                if(j+1<n) upRight = matrix[i][j]+dp[i-1][j+1];
                dp[i][j] = Math.min(up,Math.min(upLeft,upRight));
            }
        }
        int mini = dp[n-1][0];
        for(int j=1;j<n;j++){
            mini = Math.min(mini,dp[n-1][j]);
        }
        return mini;
    }
}