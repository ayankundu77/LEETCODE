class Solution {
    public int func(int i, int j, int[][] dp, int[][] grid){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = func(i-1,j,dp,grid);
        int left = func(i,j-1,dp, grid);
        return dp[i][j] = grid[i][j]+Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return func(m-1,n-1,dp,grid);
    }
}