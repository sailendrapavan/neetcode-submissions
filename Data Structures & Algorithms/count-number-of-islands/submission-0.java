class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    makeVisitable(i, j, visited, grid);
                    count++;
                }

            }
        }
        return count;
    }


    public void makeVisitable(int row, int collumn, boolean[][] visited, char[][] grid) {

        if(!(row>=0 && row<grid.length && collumn>=0 && collumn<grid[0].length)) {
            return;
        }
        if(visited[row][collumn] || grid[row][collumn] == '0') {
            return;
        }

        visited[row][collumn] = true;
        makeVisitable(row+1, collumn, visited, grid);
        makeVisitable(row-1, collumn, visited, grid);
        makeVisitable(row, collumn+1, visited, grid);
        makeVisitable(row, collumn-1, visited, grid);
    }



    
}
