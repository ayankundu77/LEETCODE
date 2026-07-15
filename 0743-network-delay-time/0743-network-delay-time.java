class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance=distance;
        this.node=node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adj.get(u).add(new Pair(wt, v));
        }
            int dist[] = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        for(int i=0;i<=n;i++){
            dist[i] = (int)1e9;
        }
        dist[k] = 0;
        pq.add(new Pair(0,k));
        while(pq.size()!=0){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            if(dis > dist[node]) continue;
            for(int i=0;i<adj.get(node).size();i++){
                int adjEdgeWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if(dis+adjEdgeWeight<dist[adjNode]){
                    dist[adjNode] = dis+adjEdgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        int ans = 0;

        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9)
            return -1;

           ans = Math.max(ans, dist[i]);
        }
    return ans;
    }
}