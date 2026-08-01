class Solution {
    int minCost = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int dp[]  = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(recursive(cost,cost.length-1,0,dp),
        recursive(cost,cost.length-1,1,dp));
        // recursive(cost,cost.length-1,1,cost[1],dp);
    }

    public int recursive(int[] cost, int target, int cur, int dp[]){
        if(cur>target){
           return 0;
        }
        if(dp[cur]!=-1){
            return dp[cur];
        }
        int oneSetp = recursive(cost,target,cur+1,dp);
        int secondStep = recursive(cost,target,cur+2,dp);
        dp[cur] = cost[cur] + Math.min(oneSetp, secondStep);
        return dp[cur];
    }


}
