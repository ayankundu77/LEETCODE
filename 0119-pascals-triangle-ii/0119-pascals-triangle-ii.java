class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> answer = new ArrayList<>();
        answer.add(1);

        for(int col=1;col<=rowIndex;col++){
            ans = ans*(rowIndex+1-col);
            ans/=col;
            answer.add((int)ans);
        }
        return answer;
    }
}