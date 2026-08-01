class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        targetSum(nums, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void targetSum(int[] nums, int target, List<List<Integer>> ans, List<Integer> result, int currentSum, int index) {
        if (target == currentSum) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (currentSum > target || index == nums.length) {
            return;
        }
        currentSum += nums[index];
        result.add(nums[index]);
        targetSum(nums, target, ans, result, currentSum, index);
        currentSum -= nums[index];
        result.removeLast();
        targetSum(nums, target, ans, result, currentSum, index + 1);
    }
}
