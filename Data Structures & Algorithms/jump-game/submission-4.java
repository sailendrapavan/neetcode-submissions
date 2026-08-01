class Solution {
    public boolean canJump(int[] nums) {
       int dp[] = new int[nums.length+1];
       Arrays.fill(dp,-1);
       return farthestGreedy(nums);
    }

    public boolean recur(int[] nums, int index, int[] dp){
        if(index>=nums.length-1){
              return true;
        }
        if(dp[index]!=-1){
            if(dp[index]==0){
                return false;
            }
            return true;
        }

        boolean found = false;
        for(int i=1;i<=nums[index];i++){
            if(recur(nums,i+index,dp)){
                dp[index] = 1;
                return true;
            }
        }
        dp[index]=0;
        return false;
    }


    public boolean farthestGreedy(int nums[]){
        int farthest=0;
        for(int i=0;i<nums.length;i++){
           if(farthest<i){
             return false;
           }
           farthest = Math.max(farthest,i+nums[i]);
           if(farthest>=nums.length-1){
            return true;
           }
        }
       return true;
    }


    public boolean canJumpVersion2(int nums[]){
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
