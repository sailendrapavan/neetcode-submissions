class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    returnSubsets(nums,0,result,new ArrayList());
    return result;
   }

   public void returnSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> list)
   {
    if(index==nums.length)
    {
        result.add(new ArrayList<>(list));
        return;
    }
    list.add(nums[index]);
    returnSubsets(nums, index+1,result,list);
    list.removeLast();
    returnSubsets(nums, index+1,result,list);
   }
}
