class Solution {
    private boolean hasDuplicate(String s, String temp){
        HashSet<Character> set = new HashSet<>();
        for(char ch : temp.toCharArray()){
            set.add(ch);
        }
        for(char ch : s.toCharArray()){
            if(set.contains(ch)) return true;
            set.add(ch);
        }
        return false;
    }
    private int func(int i, List<String> arr, String temp, int n, HashMap<String, Integer> dp){
        if(i>=n) return temp.length();
        if(dp.containsKey(temp)) return dp.get(temp);
        int include = 0, exclude = 0;
        if(hasDuplicate(arr.get(i), temp)){
            exclude = func(i+1,arr,temp,n, dp);
        }else{
            exclude = func(i+1,arr,temp,n,dp);
            include = func(i+1,arr,temp+arr.get(i),n,dp);
        }
        int ans = Math.max(exclude, include);
        dp.put(temp, ans);
        return ans;
    }
    public int maxLength(List<String> arr) {
        HashMap<String, Integer> dp = new HashMap<>();
        return func(0,arr,"",arr.size(),dp);
    }
}