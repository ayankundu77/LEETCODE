class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int it : set) {
            // Check if it is the start of a sequence
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    /* 
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt=0,longest=1;
        for(int i=0;i<n;i++){
            if(nums[i]-1==lastSmaller){
                cnt+=1;
                lastSmaller = nums[i];
            }else if(lastSmaller!=nums[i]){
                cnt=1;
                lastSmaller = nums[i];
            }
            longest = max(longest,cnt);
        }
        return longest;
    }
    */
}