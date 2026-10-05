class Solution {
    public boolean isPalindrome(int i, int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int func(int i, int n, String s, int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int mini = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,s)){
                int cost=1+func(j+1,n,s,dp);
                mini = Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,s,dp)-1;
    }
}