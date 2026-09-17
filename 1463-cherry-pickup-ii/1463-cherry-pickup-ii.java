class Solution {
    public int func(int i, int j1, int j2, int rows, int cols, int[][][] dp, int[][] grid){
        if(j1<0 || j1>=cols || j2<0 || j2>=cols) return (int)(-1e9);
        if(i==rows-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = (int)(-1e9);
        for(int robot1=-1;robot1<=1;robot1++){
            for(int robot2=-1;robot2<=1;robot2++){
                int value=0;
                if(j1==j2) value+=grid[i][j1];
                else value+=grid[i][j1]+grid[i][j2];
                value+=func(i+1,j1+robot1,j2+robot2,rows,cols,dp,grid);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int k=0;k<cols;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return func(0,0,cols-1,rows,cols,dp,grid);
    }
}