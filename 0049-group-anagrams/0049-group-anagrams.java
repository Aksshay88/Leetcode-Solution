class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> ag =new HashMap<>();
        for(String w:strs){
            char[] charArray=w.toCharArray();
            Arrays.sort(charArray);
            String sw=new String (charArray);
            if(!ag.containsKey(sw)){
                ag.put(sw,new ArrayList<>());
            }
            ag.get(sw).add(w);
        }
        return new ArrayList<>(ag.values());    
    }
}