class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));  
        HashMap<Integer, Integer> map = new HashMap<>();      
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int elem = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new int[]{elem,freq});
            if(pq.size()>k) pq.poll();
        }

        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            result[i++]=pq.poll()[0];
        }
        return result;
    }
}