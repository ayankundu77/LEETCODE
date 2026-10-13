class Solution {
    public int minFlipsMonoIncr(String s) {
        int countOnes = 0, flips = 0;
        for(char ch : s.toCharArray()){
            if(ch=='1') countOnes++;
            else flips = Math.min(flips+1, countOnes);
        }
        return flips;
    }
}