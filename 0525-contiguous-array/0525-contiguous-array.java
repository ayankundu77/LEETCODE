class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,-1);
        int currSum=0;
        int result = 0;
        for(int i=0;i<n;i++){
            currSum+= (nums[i]==1)?1:-1;
            if(mpp.containsKey(currSum)){
                result = Math.max(result, i-mpp.get(currSum));
            }else{
                mpp.put(currSum, i);
            }
        }
        return result;
    }
}