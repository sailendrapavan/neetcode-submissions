class Solution {
    HashMap<String, List<String>> map = new HashMap();
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String s:strs) {
            String ana = convertToAnagramString(s);
            final List<String> list = map.get(ana);
            if(list == null) {
                final ArrayList<String> li = new ArrayList<String>();
                li.add(s);
                map.put(ana,li);
            }else{
                list.add(s);
            }
        }
        final List<List<String>> finalList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            finalList.add(entry.getValue());
        }
        return finalList;
    }

    public String convertToAnagramString(String str){
        int ana[] = new int[26];
        String finslStr = "";
        for (int i=0;i<str.length();i++){
               ana[str.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            finslStr = finslStr + String.valueOf((char) (97 + i))+ String.valueOf(ana[i]);
        }
        return finslStr + "len" + str.length();
    }
}
