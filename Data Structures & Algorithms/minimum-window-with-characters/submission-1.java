class Solution {
    public String minWindow(String s, String t) {

        int min = Integer.MAX_VALUE;
        String res = "";

        int[] a = new int[128]; // current window
        int[] b = new int[128]; // required chars

        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;

        while (r < s.length()) {

            a[s.charAt(r)]++;

            while (match(a, b)) {

                if (min > r - l + 1) {
                    min = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                a[s.charAt(l)]--;
                l++;
            }

            r++;
        }

        return res;
    }


    public boolean match(int[] a, int[] b) {

        for (int i = 0; i < 128; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }

        return true;
    }
}