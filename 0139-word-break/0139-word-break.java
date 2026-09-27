class Solution {
    public boolean func(String s, int i, Boolean[] dp, List<String> wordDict){
        int n = s.length();
        if(i==n) return true;
        if(dp[i]!=null) return dp[i];
        for(int endIdx=i+1;endIdx<=n;endIdx++){
            String split = s.substring(i,endIdx);
            if(wordDict.contains(split) && func(s,endIdx,dp,wordDict)){
                return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean dp[] = new Boolean[n];
        return func(s,0,dp,wordDict);
    }
}