class Solution {
    public int lengthOfLongestSubstring(String s) {
        String subString = "";
        int maxLength = 0;
        for(char cr : s.toCharArray()){
            if(subString.contains(String.valueOf(cr))){
                int index = subString.indexOf(cr);
                subString = subString.substring(index+1);
            }
            subString = subString.concat(String.valueOf(cr));
            maxLength = Math.max(subString.length(),maxLength);
        }
        return maxLength;
    }
}
