class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int mini = Integer.MAX_VALUE;
        for(int num:nums){
            sum+=num;
            mini = Math.min(num,mini);
        }
        return sum-n*mini;
    }
}