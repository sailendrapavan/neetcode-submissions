class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int element = nums[i];
            if (set.contains(element - 1)) {
                continue;
            }
            while (set.contains(element+count)) {
                count++;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
