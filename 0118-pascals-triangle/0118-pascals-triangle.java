class Solution {
    public List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> answer = new ArrayList<>();
        answer.add(1);

        for(int col=1;col<row;col++){
            ans*=(row-col);
            ans/=col;
            answer.add(ans);
        }
        return answer;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ans.add(generateRow(i+1));
        }
        return ans;
    }
}