class Solution {
    public long func(int i, int j, String s, String t, long[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=func(i-1,j-1,s,t,dp);
        return dp[i][j]=1+Math.min(func(i-1,j,s,t,dp),Math.min(func(i,j-1,s,t,dp),func(i-1,j-1,s,t,dp)));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return (int)func(n-1,m-1,word1,word2,dp);
    }
}