class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n==0) return new int[0];
        TreeSet<Integer> unique = new TreeSet<>();
        for(int num : arr){
            unique.add(num);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for(int num : unique){
            hm.put(num, rank++);
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }
}