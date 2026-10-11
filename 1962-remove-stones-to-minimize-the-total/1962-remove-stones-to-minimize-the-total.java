class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.offer(piles[i]);
            sum+=piles[i];
        }
        for(int i=1;i<=k;i++){
            int currMax = pq.poll();
            int remove = currMax/2;
            sum-=remove;
            currMax-=remove;
            pq.offer(currMax);
        }
        return sum;
    }
}