class Solution {
    private int m;
    private int n;
    private long dfs(int i, int j, int[][] grid){
        long sum = grid[i][j];
        grid[i][j]=0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int ind = 0; ind < 4; ind++){
            int nrow = i + drow[ind];
            int ncol = j + dcol[ind];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
               && grid[nrow][ncol]>0){
               sum+=dfs(nrow,ncol,grid);
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k){
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long sum = dfs(i,j,grid);
                    if(sum % k==0) count++;
                }
            }
        }
        return count;
    }
}