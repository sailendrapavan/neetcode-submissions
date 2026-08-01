class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return recur(nums,target,0,memo);
    }
    int recur(int nums[], int target, int index, Map<String,Integer> memo){
        if(target==0 && index == nums.length){
            return 1;
        }
        if(index>=nums.length){
           return 0;
        }
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int add = recur(nums, target+nums[index], index+1, memo );
        int substract = recur(nums, target-nums[index], index+1,memo);
        int result = add + substract;
        memo.put(key, result);
        return result;

    }
}
