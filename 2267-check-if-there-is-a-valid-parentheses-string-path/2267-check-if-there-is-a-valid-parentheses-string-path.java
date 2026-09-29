class Solution {
    public boolean func(int i, int j, int openCount, int m, int n, char[][]grid, int[][][] dp){
        openCount+=(grid[i][j]=='(')?1:-1;
        if(openCount<0) return false;
        if(dp[i][j][openCount]!=-1) return dp[i][j][openCount]==1;
        if(i==m-1 && j==n-1){
            dp[i][j][openCount]=(openCount==0)?1:0;
            return openCount==0;
        }
        if(i+1<m){
            if(func(i+1,j,openCount,m,n,grid,dp)){
                dp[i][j][openCount]=1;
                return true;
            }
        }
        if(j+1<n){
            if(func(i,j+1,openCount,m,n,grid,dp)){
                dp[i][j][openCount]=1;
                return true;
            }
        }
        dp[i][j][openCount]=0;
        return false;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((m+n-1)%2==1) return false;
        if(grid[0][0]==')'||grid[m-1][n-1]=='(') return false;
        int[][][] dp = new int[101][101][201];
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                for(int k=0;k<201;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return func(0,0,0,m,n,grid,dp);
    }
}