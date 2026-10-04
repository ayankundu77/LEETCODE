class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, result = 0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        boolean oddFreq = false;
        for(int i : map.values()){
            if(i%2==0) result+=i;
            else{
                result = result + i - 1;
                oddFreq=true;
            }
        }
        if(oddFreq==true) result++;
        return result;
    }
}