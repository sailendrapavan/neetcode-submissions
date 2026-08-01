class Solution {

    public int[] twoSumVersion2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target){
        int copy[][] = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }

        Arrays.sort(copy, Comparator.comparingInt(a->a[0]));
        int i =0, j= nums.length -1;

        while(i<j){
            int cur = copy[i][0]+copy[j][0];
            if(cur== target){
                return new int[]{Math.min(copy[i][1], copy[j][1]),
                                 Math.max(copy[i][1], copy[j][1])};
            }
            if(cur<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[0];
    }
}
