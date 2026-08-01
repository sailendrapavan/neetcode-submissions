class Solution {

    public int climbStairs(int n) {
        int[] ar = new int[n+1]; 
        Arrays.fill(ar, -1);
        return climb2(n,ar);
    }



    public int climb2(int index, int[] ar){
        if(index<0){
            return 0;
        }
        if(index==0){
            return 1;
        }
        if(ar[index]!=-1){
            return ar[index];
        }
        int oneStep = climb2(index-2,ar);
        int twoStep = climb2(index-1,ar);
        int result =  oneStep + twoStep;
        ar[index] = result;
        return result;
    }
}
