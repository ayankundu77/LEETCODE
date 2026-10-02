class Solution {
    boolean compare(String s1, String s2, String[] words){
        if(s1.length()!=s2.length()+1) return false;
        int i=0, j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++; j++;
            }else{
                i++;
            }
        }
        if(j==s2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words,(s1,s2)->s1.length()-s2.length());
        Arrays.fill(dp, 1);
        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (compare(words[i],words[prev],words)==true && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;
    }
}