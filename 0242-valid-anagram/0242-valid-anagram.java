class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int hash[] = new int[256];
        Arrays.fill(hash,0);

        for(char ch : s.toCharArray()){
            hash[ch]++;
        }
        for(char ch : t.toCharArray()){
            hash[ch]--;
        }

        for(int i=0; i<256; i++){
            if(hash[i]!=0) return false;
        }
        return true;
    }
}