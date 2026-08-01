class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       int n = grid.length;
       int sum = 0;
       int totalXor = 0;
       int count[] = new int[n*n+1];

       for(int i =0;i<n;i++){
        for(int j=0;j<n;j++){
            count[grid[i][j]]++;
            
        }
       }



    int zero=0;
    int twice=0;

    for(int i =1;i<=n*n;i++){
        if(count[i]==0){
            zero = i;
        }else if (count[i]==2){
            twice = i;
        }
    
       }
        return new int[]{twice,zero};
    }
   

}