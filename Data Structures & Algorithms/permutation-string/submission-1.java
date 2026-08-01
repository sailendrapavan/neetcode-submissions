class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
        }
        int[] b = new int[26];
        int l = 0, r = 0;
        int count = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            b[c - 'a']++;
            count++;
            if (count == s1.length()) {
                boolean flag = true;
                for (int i = 0; i < 26; i++) {
                    if (b[i] != a[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
                char left = s2.charAt(l);
                b[left - 'a']--;
                l++;
                count = count - 1;
            } else if (count > s1.length()) {
                char left = s2.charAt(l);
                b[left - 'a']--;
                l++;
                count = count - 1;
            }
            r++;
        }
        return false;
    }
}
