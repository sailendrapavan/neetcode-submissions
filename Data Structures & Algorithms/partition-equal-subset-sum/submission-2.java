class Solution {
    boolean found = false;
    public boolean canPartition(int[] nums) {

         int sum = 0;
         for(int a: nums){
            sum = sum + a;
         }
         if(sum%2!=0){
             return false;
         }
        int targetSum = sum/2;
        int dp[][] = new int[nums.length+1][targetSum+1];
         for(int[] row: dp){
            Arrays.fill(row,-1);
         }
        return recr(nums,0,targetSum, dp);
    }

    public boolean recr(int nums[], int index,int targetSum, int[][] dp){
      if(targetSum==0){
        dp[index][targetSum] = 1;
        return true;
      }
      if(index==nums.length || targetSum<0){
        dp[index][targetSum] = 0;
        return false;
      }

      if(dp[index][targetSum]!=-1){
        if(dp[index][targetSum]==0){
            return false;
        }
        return true;
      }

      boolean notTake =  recr(nums, index+1, targetSum,dp);
      boolean take = false;
      if(targetSum>=nums[index]){
         take = recr(nums, index+1, targetSum - nums[index],dp);
      }
      if(take||notTake){
        dp[index][targetSum] = 1;
        return true;
      }
      dp[index][targetSum] = 0;
      return false;
    }


     // we cannot memorise this as state is very diferent at each stage
    public void recur(int nums[], int index, int leftSum, int rightSum){
       if(index==nums.length){
          if(!found && leftSum==rightSum){
            found = true;
          }
          return;
       }
       recur(nums, index+1, nums[index]+ leftSum, rightSum);
       recur(nums, index+1, leftSum, nums[index] + rightSum);
    }
}
