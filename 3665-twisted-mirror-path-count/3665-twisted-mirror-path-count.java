class Solution {
    int left = 0, up = 1;
    int MOD = 1000000007;
    int m,n;
    private int func(int[][] grid, int i, int j, int cameFrom, int[][][] dp){
        if(i>=m||j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j][cameFrom]!=-1) return dp[i][j][cameFrom];
        if(grid[i][j]==1){
            if(cameFrom==left){
                return dp[i][j][cameFrom]=func(grid,i+1,j,up,dp);
            }else{
                return dp[i][j][cameFrom]=func(grid,i,j+1,left,dp);
            }
        }
        int totPaths = 0;
        totPaths = (totPaths+func(grid,i,j+1,left,dp))%MOD;
        totPaths = (totPaths+func(grid,i+1,j,up,dp))%MOD;
        return dp[i][j][cameFrom]=totPaths;
    }
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][][] dp = new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        return func(grid,0,0,left,dp);
    }
}