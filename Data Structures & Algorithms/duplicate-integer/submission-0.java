class Solution {
    HashSet set = new HashSet();
    public boolean hasDuplicate(int[] nums) {
    for(int i = 0;i<=nums.length-1;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}