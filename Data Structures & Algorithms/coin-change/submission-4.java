class Solution {

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int [] row: dp )
        {
            Arrays.fill(row,-2);
        }
        int result =  recur(coins,amount,coins.length-1,dp);
        return result;
    }

    public int recur(int[] coins, int target, int index, int dp[][]){
        if(target == 0){
            return 0;
        }
        if (target < 0 || index < 0) {
            return -1;
        }
        if(dp[index][target]!=-2){
            return dp[index][target];
        }
        int nottake = recur(coins, target, index-1,dp);
        int takecoin = -1;
        if (coins[index] <= target) {
            int res = recur(coins, target - coins[index], index,dp);
            if (res != -1) {
                takecoin = 1 + res;
            }
        }
        if (takecoin == -1) {
            dp[index][target] = nottake;
            return nottake;
        }
        if (nottake == -1) {
            dp[index][target] = takecoin;
            return takecoin;
        }
        int result = Math.min(takecoin, nottake);
        dp[index][target] = result;
        return dp[index][target];
    }
}
