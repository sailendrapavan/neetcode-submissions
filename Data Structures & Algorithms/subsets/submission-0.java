class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums,new ArrayList<>(), 0, ans);
        return ans;
    }


    public void dfs(int[] nums, List<Integer> cur, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, cur, index + 1, ans);
        cur.removeLast();
        dfs(nums, cur, index + 1, ans);
    }
}
