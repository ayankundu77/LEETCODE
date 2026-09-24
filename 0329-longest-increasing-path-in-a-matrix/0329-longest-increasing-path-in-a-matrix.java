class Solution {
    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] dp){
        if(dp[i][j]>0) return dp[i][j];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int maxi = 0;
        for(int idx = 0; idx < 4; idx++){
            int newr = i + drow[idx];
            int newc = j + dcol[idx];
            if(newr>=0 && newc>=0 && newr<m && newc<n && matrix[newr][newc]>matrix[i][j]){
                maxi = Math.max(maxi,dfs(matrix,m,n,newr,newc,dp));
            }
        }
        return dp[i][j]=maxi+1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int longestPath = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int path = dfs(matrix,m,n,i,j,dp);
                longestPath = Math.max(path,longestPath);
            }
        }
        return longestPath;
    }
}