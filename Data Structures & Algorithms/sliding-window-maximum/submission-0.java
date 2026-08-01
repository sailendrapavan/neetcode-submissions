class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int r = 0;
        int l = 0;
        for (; r < nums.length && r < k; r++) {
            maxHeap.add(nums[r]);
        }
        while (r < nums.length) {
            int element = maxHeap.peek();
            result[count] = element;
            maxHeap.add(nums[r]);
            maxHeap.remove(nums[l]);
            count++;
            l++;
            r++;
        }
        result[count] = maxHeap.peek();
        return result;
    }
}
