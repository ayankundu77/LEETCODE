class Solution {
    int mod = 1000000007;
    public int func(int start, int n, String s, int k, int[] dp){
        if(start>=n) return 1;
        if(dp[start]!=-1) return dp[start];
        if(s.charAt(start)=='0') return 0;
        long ans = 0;
        long num = 0;
        for(int end = start; end<n; end++){
            num=(num*10)+(s.charAt(end)-'0');
            if(num>k) break;
            ans = (ans%mod+func(end+1,n,s,k,dp)%mod)%mod;
        }
        return dp[start]=(int)ans;
    }
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,s,k,dp);
    }
}