class Solution {
    public int longestCommonSubsequence(int n, int m, String text1, String text2) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return n+m-2*(longestCommonSubsequence(n,m,word1,word2));
    }
}