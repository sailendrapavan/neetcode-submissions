class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums2 = Arrays.stream(candidates).sorted().toArray();
        targetSumUnique(nums2, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void targetSumUnique(int[] nums, int target, List<List<Integer>> ans, List<Integer> result, int currentSum, int index) {
        if (target == currentSum) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (currentSum > target || index >= nums.length) {
            return;
        }
        currentSum += nums[index];
        result.add(nums[index]);
        targetSumUnique(nums, target, ans, result, currentSum, index + 1);
        currentSum -= nums[index];
        result.removeLast();
        while (index + 1 <= nums.length - 1 && nums[index] == nums[index + 1]) {
            index = index + 1;
        }
        targetSumUnique(nums, target, ans, result, currentSum, index + 1);
    }
}
