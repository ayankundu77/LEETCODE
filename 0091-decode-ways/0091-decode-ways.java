class Solution {
    public int func(int i, String s, int n, int[] dp){
        if(dp[i]!=-1) return dp[i];
        if(i==n) return dp[i]=1;
        if(s.charAt(i)=='0') return dp[i]=0;
        int result = func(i+1,s,n,dp);
        if(i+1<n){
            if(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<='6') result+=func(i+2,s,n,dp);
        }
        return dp[i]=result;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[101];
        Arrays.fill(dp,-1);
        return func(0,s,n,dp);
    }
}