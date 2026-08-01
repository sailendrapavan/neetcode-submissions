class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recur(nums,target,0);
    }
    int recur(int nums[], int target, int index){
        if(target==0 && index == nums.length){
            return 1;
        }
        if(index>=nums.length){
           return 0;
        }
        int add = recur(nums, target+nums[index], index+1);
        int substract = recur(nums, target-nums[index], index+1);
        return add + substract;

    }
}
