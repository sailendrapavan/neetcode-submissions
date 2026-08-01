class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int expectedResult = ((nums.length)*(nums.length+1)/2);
        for(int num: nums){
             result = result +num;
        }
        return expectedResult-result;
        
    }
}
