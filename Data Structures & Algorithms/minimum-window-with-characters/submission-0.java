class Solution {
    public String minWindow(String s, String t) {
        String s1=s;
        String s2 =t;
        int[] need = new int[128];
        for(char c : s2.toCharArray()) {
            need[c]++;
        }

        int l = 0;
        int count = s2.length();

        int min = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0; r < s1.length(); r++) {

            char c = s1.charAt(r);

            if(need[c] > 0) {
                count--;
            }

            need[c]--;

            while(count == 0) {

                if(r - l + 1 < min) {
                    min = r-l+1;
                    start = l;
                }

                char left = s1.charAt(l);

                need[left]++;

                if(need[left] > 0) {
                    count++;
                }

                l++;
            }
        }

        return min == Integer.MAX_VALUE
                ? ""
                : s1.substring(start, start + min);
    }
}
