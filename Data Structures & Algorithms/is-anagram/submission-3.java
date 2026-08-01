class Solution {
    int [] charCounts = new int [26];
    public boolean isAnagram(String s, String t) {
        int[] first = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a']++;
            first[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
