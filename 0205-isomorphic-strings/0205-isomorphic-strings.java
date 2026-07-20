class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash,0);
        boolean[] isMapped = new boolean[256];
        Arrays.fill(isMapped, false);
        for(int i=0;i<n;i++){
            if(hash[s.charAt(i)]==0 && isMapped[t.charAt(i)]==false){
                hash[s.charAt(i)] = t.charAt(i);
                isMapped[t.charAt(i)] = true;
            }
        }
        for(int i=0;i<n;i++){
            if((char)hash[s.charAt(i)]!=t.charAt(i)) return false;
        }
        return true;
    }
}