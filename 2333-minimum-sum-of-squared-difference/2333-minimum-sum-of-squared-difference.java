class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums2.length;
        int[] countDiff = new int[100001];
        long total = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            countDiff[diff]++;
            total += diff;
        }
        long K = (long) k1 + k2;
        if (total <= K) return 0;
        for(int currDiff = 100000; currDiff>0 && K>0; currDiff--){
            int countOps = (int)Math.min(countDiff[currDiff],K);
            countDiff[currDiff]-=countOps;
            countDiff[currDiff-1]+=countOps;
            K-=countOps;
        }
        long result = 0;
        for(int d=1; d<=100000; d++){
            result += (long) d * d * countDiff[d];
        }
        return result;
    }
}