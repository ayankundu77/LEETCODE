class Solution {
    private int m,n;
    private boolean dfs(int grid[][], int i, int j){
        if(i<0||i>=m||j<0||j>=n) return false;
        if(grid[i][j]==1) return true;
        grid[i][j]=1;
        boolean result = true;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int ind = 0; ind < 4; ind++){
            int nrow = i + drow[ind];
            int ncol = j + dcol[ind];
            if(dfs(grid,nrow,ncol)==false) result = false;
        }
        return result;
    }
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)) count++;
                }
            }
        }
        return count;
    }
}