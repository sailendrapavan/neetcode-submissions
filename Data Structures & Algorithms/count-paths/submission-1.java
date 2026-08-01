class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,m,n,dp);
        
    }

    int recur(int i, int j, int m, int n,int[][] dp ) {
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>m-1|| j>n-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right = 0;
        if(j+1<n){
        right = recur(i, j+1,m,n,dp);
        }
        int down = 0;
        if(i+1<m){
          down = recur(i+1, j,m,n,dp);
        }
        int result = right+down;
        dp[i][j] = result;
        return result;
    }
}
