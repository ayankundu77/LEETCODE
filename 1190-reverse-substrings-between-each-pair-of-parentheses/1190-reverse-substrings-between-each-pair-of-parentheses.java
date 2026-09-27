class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> openBracketIdx = new Stack<>();
        int[] closeBracketIdx = new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                openBracketIdx.push(i);
            }else if(s.charAt(i)==')'){
                int j = openBracketIdx.peek();
                openBracketIdx.pop();
                closeBracketIdx[i]=j;
                closeBracketIdx[j]=i;
            }
        }
        StringBuilder result = new StringBuilder();
        int flag=1;
        for(int i=0;i<n;i+=flag){
            if(s.charAt(i)=='('||s.charAt(i)==')'){
                i=closeBracketIdx[i];
                flag=-flag;
            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();

    }
}