class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> hs = new HashSet<>();
        for(List<String> path : paths){
            String source = path.get(0);
            hs.add(source);
        }
        for(List<String> path : paths){
            String destination = path.get(1);
            if(!hs.contains(destination)) return destination;
        }
        return " ";
    }
}