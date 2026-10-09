class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int ans = 0;
        int count = 0, i = 0;
        while(i<n){
            if(s.charAt(i)=='('){
                count++;
                i++;
            }else{
                if(count>0) count--;
                else ans++;

                if(i+1<n && s.charAt(i+1)==')'){
                    i=i+2;
                }else{
                    ans++;
                    i++;
                }
            }
        }
        return ans+count*2;
    }
}