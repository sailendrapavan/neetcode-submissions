class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1;
        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && target<=matrix[i][n-1]){
                row = i;
                break;
            }
        }

        if(row == -1) {
            return false;
        }

        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            if(matrix[row][mid]>target){
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}
