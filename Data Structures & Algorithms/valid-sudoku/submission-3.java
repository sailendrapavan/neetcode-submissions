class Solution {
    public boolean isValidSudoku(char[][] board) {
         HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String lat = "lat" + i + "_" + board[i][j];
                    String lon = "lon" + j + "_" + board[i][j];
                    String box = "box" + i / 3 + j / 3 + "_" + board[i][j];
                    if (set.contains(lat) || set.contains(lon) || set.contains(box)) {
                        return false;
                    }
                    set.add(lat);
                    set.add(lon);
                    set.add(box);
                }

            }
        }
        return true;
    }
}
