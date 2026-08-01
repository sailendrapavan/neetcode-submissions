class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return recur(nums, 0,memo);
    }

    public int recur(int []nums, int index, int[] memo){
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int rob = nums[index] + recur(nums, index+2, memo);
        int notRob = recur(nums,index+1, memo);
        int result = Math.max(rob,notRob);
        memo[index] = result;
        return result;
    }
}
