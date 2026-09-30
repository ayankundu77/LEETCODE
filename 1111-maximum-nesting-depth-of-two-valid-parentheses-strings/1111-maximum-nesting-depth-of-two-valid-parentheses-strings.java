class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int depth=0;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                depth++;
                result[i] = (depth%2==0)?0:1;
            }else if(seq.charAt(i)==')'){
                result[i] = (depth%2==0)?0:1;
                depth--;
            }
        }
        return result;
    }
}