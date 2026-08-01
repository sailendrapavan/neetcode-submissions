class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int result = recur(nums,0,dp);
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    int recur(int[] nums, int index, int [] dp){
        if(index>=nums.length-1){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int result=Integer.MAX_VALUE;
        for(int i =1;i<=nums[index];i++){
            int steps = recur(nums, i+index,dp);
            if(steps != Integer.MAX_VALUE) {
                result = Math.min(result, steps+1);
            }
        }
        dp[index] = (result==Integer.MAX_VALUE?Integer.MAX_VALUE:result);
        return  dp[index] ;
    }
}
