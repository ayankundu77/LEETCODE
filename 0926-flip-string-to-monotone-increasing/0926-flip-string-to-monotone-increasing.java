class Solution {
    private int func(int n, String s, int currIdx, int prev, int[][] dp){
        if(currIdx>=n) return 0;
        if(dp[currIdx][prev]!=-1) return dp[currIdx][prev];
        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;
        if(s.charAt(currIdx)=='0'){
            if(prev==1){
                flip = 1+func(n,s,currIdx+1,1,dp);
            }else{
                flip = 1+func(n,s,currIdx+1,1,dp);
                notFlip = func(n,s,currIdx+1,0,dp);
            }
        }else if(s.charAt(currIdx)=='1'){
            if(prev==1){
                notFlip = func(n,s,currIdx+1,1,dp);
            }else{
                flip = 1+func(n,s,currIdx+1,0,dp);
                notFlip = func(n,s,currIdx+1,1,dp);
            }
        }
        return dp[currIdx][prev]=Math.min(flip, notFlip);
    }
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return func(n,s,0,0,dp);
    }
}