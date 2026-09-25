class Solution {
    public static String func(int n, int m, String text1, String text2) {
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
        int len = n+m-dp[n][m];
        char ans[] = new char[len];
        int index = len-1;
        int i=n, j=m;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                ans[index]=text1.charAt(i-1); index--;
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                ans[index]=text1.charAt(i-1); index--;
                i--;
            }else{
                ans[index]=text2.charAt(j-1); index--;
                j--;
            }
        }
        while(i>0){
            ans[index]=text1.charAt(i-1); index--; i--;
        }
        while(j>0){
            ans[index]=text2.charAt(j-1); index--; j--;
        }
        return new String(ans);
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        return func(n,m,str1,str2);
    }
}