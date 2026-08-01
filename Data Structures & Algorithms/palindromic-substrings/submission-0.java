class Solution {
    public int countSubstrings(String s) {
        return generateStrings(s).size();
    }



    int checkIfPallendrome(String s, int i, int j, int dp[][]){
        if(i>=j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j] = checkIfPallendrome(s,i+1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = 0;
        return dp[i][j];
    }


    public List<String> generateStrings(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        List<String> list = new ArrayList<String>();
        
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                if(checkIfPallendrome(s,i,j,dp)==1){
                    list.add(s.substring(i,j+1));
                }
            }
        }
        return list;
    }
}
