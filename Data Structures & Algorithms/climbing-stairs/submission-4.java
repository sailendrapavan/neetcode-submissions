class Solution {

    public int climbStairs(int n) {
        int[] ar = new int[46]; 
        Arrays.fill(ar, -1);
    return climb2(ar,0,n);
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

    public int climb2(int ar[], int n, int target){
        if(n==target){
            return 1;
        }
        if(n>target){
            return 0;
        }
        if(ar[n]!=-1){
            return ar[n];
        }
        int onestep = climb2(ar,n+1,target);
        int secondSteep = climb2(ar,n+2,target);
        ar[n] = onestep+ secondSteep;
        return ar[n]; 
    }
}
