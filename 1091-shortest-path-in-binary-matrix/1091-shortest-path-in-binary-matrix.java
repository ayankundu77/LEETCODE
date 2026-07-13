class tuple{
    int weight, row, column;
    tuple(int weight, int row, int column){
        this.weight = weight;
        this.row = row;
        this.column = column;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
            if (n == 1)
            return 1;
        Queue<tuple> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0]=1;
        q.add(new tuple(1,0,0));
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            tuple it = q.poll();
            int dis = it.weight;
            int r = it.row;
            int c = it.column;
            for(int i=0;i<8;i++){
                int newr = r+dr[i];
                int newc = c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc]==0 && dis+1<dist[newr][newc]){
                    dist[newr][newc] = dis+1;
                    if(newr==n-1 && newc==n-1) return dis+1;
                    q.offer(new tuple(1+dis,newr,newc));
                }
            }
        }
        return -1;
    }
}