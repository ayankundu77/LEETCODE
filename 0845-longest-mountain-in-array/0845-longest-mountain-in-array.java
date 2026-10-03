class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		int maxi=0;
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		
		for (int i = 1; i < n; i++) {
			if (arr[i-1]<arr[i] && 1 + dp1[i-1] > dp1[i]) {
				dp1[i] = 1 + dp1[i-1];
			}
		}
		
		for (int i = n-2; i >= 0; i--) {
			if (arr[i+1]<arr[i] && 1 + dp2[i+1] > dp2[i]) {
				dp2[i] = 1 + dp2[i+1];
			}
		}
		for (int i = 0; i < n; i++) {
		    if (dp1[i] > 1 && dp2[i] > 1) maxi = Math.max(dp1[i]+dp2[i]-1,maxi);
		}
		return maxi;
    }
}