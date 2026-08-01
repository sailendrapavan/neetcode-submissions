class Solution {
    HashMap<String, List<String>> map = new HashMap();
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String s:strs) {
            int ana[] = new int[26];
            StringBuilder sb = new StringBuilder();
            for( char c : s.toCharArray()){
                ana[c-'a']++;
            }
            for(int i=0;i<26;i++){
                sb.append("#").append(ana[i]);
            }
            String finalString = sb.toString();
            if(!map.containsKey(finalString)) {
                map.put(finalString,new ArrayList<>());
            }
            map.get(finalString).add(s);
            }
        return new ArrayList<>(map.values());
    }
}
