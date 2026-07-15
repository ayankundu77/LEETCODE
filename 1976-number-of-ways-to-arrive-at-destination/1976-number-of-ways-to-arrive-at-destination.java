class Pair{
    long node;
    int weight;
    Pair(long node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.node, y.node));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i=0;i<n;i++){
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        int mod = (int)(1e9+7);
        while(pq.size()!=0){
            long dis = pq.peek().node;
            int node = pq.peek().weight;
            pq.remove();
            if (dis > dist[node]) continue;

            for(Pair it:adj.get(node)){
                int adjNode = (int)it.node;
                int adjedw = it.weight;
                if(dis+adjedw<dist[adjNode]){
                    dist[adjNode] = dis+adjedw;
                    pq.add(new Pair(dist[adjNode],adjNode));
                    ways[adjNode] = ways[node];
                }else if(dis+adjedw==dist[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}