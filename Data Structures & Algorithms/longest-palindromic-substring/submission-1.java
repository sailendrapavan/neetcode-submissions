class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return twopointers(s);        
    }

    public int recur(String s , int i , int  j, int[][] dp){
        if(i>=j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j] = recur(s,i+1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = 0;
        return 0;
    }

    public String generateAllSubStrings(String s, int[][]dp){
        int maxLen = Integer.MIN_VALUE;
        int startIndex = 0;
        for(int i =0;i<s.length();i++){
           for(int j=i;j<s.length();j++){
             if(recur(s,i,j,dp)==1){
                if(j-i+1>maxLen){
                    maxLen = j-i+1;
                    startIndex = i;
                }
             }
           }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }


    public String expand(String s, int i, int j){
        while(i>=0 && j <s.length()&& s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }


    public String twopointers(String s) {
        int n = s.length();
        String max_str= s.substring(0,1);
        for(int i =0;i<n;i++){
           String odd = expand(s,i,i);
           String even = expand(s,i,i+1);
           if(odd.length()>max_str.length()){
            max_str = odd;
           }

        if(even.length()>max_str.length()){
            max_str = even;
           }
        }
        return max_str;
    }




}
