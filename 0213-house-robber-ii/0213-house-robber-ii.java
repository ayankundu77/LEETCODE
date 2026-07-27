class Solution {
    public int func(int[] arr) {
        int n = arr.length;
        int prev=arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1) pick+=prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i=0;i<n;i++){
            if(i!=0) temp1[i]=nums[i];
            if(i!=n-1) temp2[i]=nums[i];
        }
        return Math.max(func(temp1),func(temp2));
    }
}
