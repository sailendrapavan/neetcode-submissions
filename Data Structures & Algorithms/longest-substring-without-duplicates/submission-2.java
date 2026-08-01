class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 1;
        int length = s.length();
        int maxLength = 1;
        HashSet<Character> set = new HashSet();
        if(s.length()==0){
            return 0;
        }
        set.add(s.charAt(l));
        while (r<length){
            Character cur = s.charAt(r);
            if(set.contains(cur)){
                while(s.charAt(l)!=cur){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            set.add(cur);
            r++;
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
