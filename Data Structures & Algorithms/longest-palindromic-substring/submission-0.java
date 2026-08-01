class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return generateAllSubStrings(s,dp);        
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
}
