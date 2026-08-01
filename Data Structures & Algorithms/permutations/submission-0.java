class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new HashSet<>(), res, new ArrayList<>());
        return res;

      
    }


    public void permute(int[] nums, HashSet<Integer> set, List<List<Integer>> res, List<Integer> result) {

        if (result.size() == nums.length) {
            res.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            result.add(nums[i]);
            set.add(nums[i]);
            permute(nums, set, res, result);
            result.removeLast();
            set.remove(nums[i]);
        }

    }
}
