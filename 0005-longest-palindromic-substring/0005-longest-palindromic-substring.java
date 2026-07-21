class Solution {
    public boolean isPalindrome(int i, int j,String str){
        if(i>=j){
            return true;
        }
        if(str.charAt(i)==str.charAt(j))
            return isPalindrome(i+1,j-1,str);
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int sp = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)==true){
                    if(j-i+1>maxLen){                    
                        sp=i;
                        maxLen=j-i+1;
                    }
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }
}