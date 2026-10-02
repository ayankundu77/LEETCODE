class Solution {
    public void func(int n, String curr, int open , int close, List<String> result){
        if(curr.length()==2*n){
            result.add(curr);
            return;
        }
        if(open<n){
            curr+='(';
            func(n,curr,open+1,close,result);
            curr=curr.substring(0,curr.length()-1);
        }
        if(close<open){
            curr+=')';
            func(n,curr,open,close+1,result);
            curr=curr.substring(0,curr.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        func(n, "", 0, 0, result);
        return result;
    }
}