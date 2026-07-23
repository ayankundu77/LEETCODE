class Solution {
    public boolean isConcatenated(String word, Set<String>st, Map<String,Boolean> hm){
        if(hm.containsKey(word)){
            return hm.get(word);
        }
        for(int i=0;i<word.length();i++){
            String prefix = word.substring(0,i+1);
            String suffix = word.substring(i+1,word.length());
            if(st.contains(prefix) && st.contains(suffix) || st.contains(prefix) && isConcatenated(suffix,st,hm)){
                hm.put(word,true);
                return true;
            }
        }
        hm.put(word,false);
            return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String, Boolean> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        for(String word:words){
            hs.add(word);
        }
        List result = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(isConcatenated(words[i], hs, hm)){
                result.add(words[i]);
            }
        }
        return result;
    }
}