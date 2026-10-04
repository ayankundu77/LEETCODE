class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                low++; 
                high++;
            }else if(s.charAt(i)==')'){
                low--;
                high--;
            }else{
                low--;
                high++;
            }
            if(high<0) return false;
            low = Math.max(0,low);
        }
        return low==0;
    }
}