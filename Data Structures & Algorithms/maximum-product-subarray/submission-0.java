class Solution {
    public int maxProduct(int[] nums) {
        int prefixSum = 1;
        int suffixSum = 1;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(prefixSum==0){
                prefixSum = 1;
            }
            if(suffixSum==0){
                suffixSum = 1;
            }
            prefixSum= prefixSum * nums[i];
            suffixSum = suffixSum * nums[nums.length-i-1];
            max = Math.max(max,Math.max(prefixSum,suffixSum));
        }
        return max;
    }
}
