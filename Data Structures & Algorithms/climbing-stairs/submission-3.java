class Solution {

    public int climbStairs(int n) {
        int[] ar = new int[46]; 
        Arrays.fill(ar, -1);
        ar[0]=1;
        ar[1]=1;
    return climb(ar,n);
    }

    public int climb(int ar[], int n ){
        if(n<=0){
            return 1;
        }
        if(ar[n]!=-1){
            return ar[n];
        }
        int sol = climb(ar,n-1)+climb(ar,n-2);
        ar[n]=sol;
        return sol; 
    }
}
