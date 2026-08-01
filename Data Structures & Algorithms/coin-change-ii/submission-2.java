class Solution {

    public int change(int amount, int[] coins) {
       int dp[][] = new int[coins.length+1][amount+1];
       for(int row[]: dp){
         Arrays.fill(row,-1);
       }
       return recur(coins, amount,coins.length-1,dp);
    }

    public int recur(int[] coins, int target, int index, int dp[][]){
        if(target == 0){
            return 1;
        }
        if(index<0|| target<0){
            return 0;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notTake = recur(coins, target, index-1,dp);
        int take = 0;
        if(target>=coins[index]){
            take = recur(coins, target-coins[index], index,dp);
        }
        int result = take + notTake;
        dp[index][target] = result;
        return result;
    }
}
