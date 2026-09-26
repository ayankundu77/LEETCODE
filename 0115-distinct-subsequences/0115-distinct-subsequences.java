class Solution {
    public long func(int i, int j, String s, String t, long[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=func(i-1,j-1,s,t,dp)+func(i-1,j,s,t,dp);
        else return dp[i][j]=func(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return (int)func(n-1,m-1,s,t,dp);
    }
}