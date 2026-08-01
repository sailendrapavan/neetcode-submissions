class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> lon = new HashSet<Character>();
        Set<Character> lat = new HashSet<Character>();
        for(int i=0;i<9;i++){
            lon = new HashSet<Character>();
            lat = new HashSet<Character>();
            for(int j=0; j<9; j++) {
                if(board[i][j] !='.' && !lon.add(board[i][j])){
                    return false;
                }
                if(board[j][i] !='.' && !lat.add(board[j][i])){
                    return false;
                }
            }
        }
        System.out.println("test");
        Set<Character> box = new HashSet<Character>();
        int j=0;
        while (j<9) {
            for(int i = 0 ;i<9;i++) {
                if(i%3==0) {
                    box = new HashSet<Character>();
                    System.out.println("end");
                }
                int q = j+3;
                for(int p = j;p<q;p++){
                    if( board[i][p] !='.' && !box.add(board[i][p])){
                         return false;
                    }
                }
            }
            j=j+3;
        }
        return true;
    }
}
