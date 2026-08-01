class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        int maxWithoutLast = recur(nums, nums.length-2,memo);
        Arrays.fill(memo,-1);
        int [] copy = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            copy[i-1] = nums[i]; 
        }
        int withoutfirst = recur(copy, copy.length-1,memo);
        return Math.max(maxWithoutLast,withoutfirst);
    }


        public int recur(int []nums, int index, int[] memo){
        if(index<0){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int rob = nums[index] + recur(nums, index-2, memo);
        int notRob = recur(nums,index-1, memo);
        int result = Math.max(rob,notRob);
        memo[index] = result;
        return result;
    }
}
