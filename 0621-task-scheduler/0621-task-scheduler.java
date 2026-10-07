class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
        int countInterval = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=1; i<=n+1; i++){
                if(!pq.isEmpty()){
                    int freq = pq.peek();
                    pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int val : temp){
                if(val > 0){
                    pq.add(val);
                }
            }
            if(!pq.isEmpty()){
                countInterval += n+1;
            }
            else{
                countInterval += temp.size();
            }
        }
        return countInterval; 
    }
}