class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            int n = str.length();
            if(n>=2 && str.charAt(n-1)==ch && str.charAt(n-2)==ch) continue;
            str.append(ch);
        }
        return str.toString();
    }
}