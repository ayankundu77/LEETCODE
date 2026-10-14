class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Long, Integer>[] mp = new HashMap[n];
        for(int i=0;i<n;i++){
            mp[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                long diff = (long)nums[i]-nums[j];
                int countAtJ = mp[j].getOrDefault(diff,0);
                result+=countAtJ;
                mp[i].put(diff,mp[i].getOrDefault(diff,0)+countAtJ+1);
            }
        }
        return result;
    }
}