class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private int bfs(int ro, int co, int[][] vis, int[][] grid){
        vis[ro][co]=1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove(); area++;
            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};
 
            for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow, ncol));
            }
        }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0, maxi = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]==1){
                    int area = bfs(row,col,vis,grid);
                    maxi = Math.max(maxi,area);
                }
            }
        }
        return maxi;
    }
}