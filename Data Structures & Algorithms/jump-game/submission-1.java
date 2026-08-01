class Solution {
    public boolean canJump(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    visited[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && i != 0)
                continue;
            int j = nums[i];
            while (j > 0) {
                if ((i + j < nums.length) && !(visited[i + j])) {
                    visited[i + j] = true;
                }
                j--;
            }
        }
        return visited[nums.length - 1];
    }
}
