class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int l=n/2;l>=1;l--){
            if(n%l==0){
                int appendCnt = n/l;
                String pattern = s.substring(0,l);
                StringBuilder newStr = new StringBuilder();
                while(appendCnt>0){
                    newStr.append(pattern);
                    appendCnt--;
                }
                if(s.equals(newStr.toString())) return true;
            }
        }
        return false;
    }
}