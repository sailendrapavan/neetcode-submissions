class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for( int[] row: dp){
            Arrays.fill(row,-1);
        }
        return recur(nums,-1,0,dp);
    }

    public int recur(int[] nums, int prev_index, int index, int[][] dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev_index+1]!=-1){
            return dp[index][prev_index+1];
        }
        int notTake = 0 + recur(nums,prev_index, index+1, dp);
        int take = 0;
        if(prev_index==-1 || nums[index]>nums[prev_index]){
            take = 1 + recur(nums,index, index+1,dp);
        }
        int result =  Math.max(notTake,take);
        dp[index][prev_index+1] = result;
        return result;

    }
}
