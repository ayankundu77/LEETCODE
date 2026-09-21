class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] prevCount = new long[k];

        for(int i=0;i<n;i++){
            long[] currCount = new long[k];
            int currRem = nums[i]%k;
            currCount[currRem]++;

            for(int oldRem=0;oldRem<=k-1;oldRem++){
                int newRem = (int)(((long)oldRem*nums[i]%k)%k);
                currCount[newRem]+=prevCount[oldRem];
            }
            prevCount=currCount;
            for(int x=0;x<k;x++){
                result[x]+=currCount[x];
            }
        }
        return result;
    }
}