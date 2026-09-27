class Solution {
    public boolean func(int i, int j, String s, String p, Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int k=0;k<=i;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];

        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
            return dp[i][j]=func(i-1,j-1,s,p,dp);
        }

        if(p.charAt(i)=='*'){
            return dp[i][j]=func(i-1,j,s,p,dp)||func(i,j-1,s,p,dp);
        }
        return dp[i][j]=false;
    }
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m];
        return func(n-1,m-1,s,p,dp);
    }
}