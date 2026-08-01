class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = Math.max(count,bfsVersion2(i, j, visited, grid));
                }
            }
        }
        return count;
    }

    public int bfsVersion2(int row, int collumn, boolean[][] visited, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, collumn});
        visited[row][collumn] = true;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{-1, 0});
        list.add(new int[]{1, 0});
        list.add(new int[]{0, 1});
        list.add(new int[]{0, -1});
        int count =1;
        while (!queue.isEmpty()) {
            int element[] = queue.remove();
            int presentRow = element[0];
            int presentColumn = element[1];
            for (int[] nextPair : list) {
                int nr = presentRow + nextPair[0];
                int nc = presentColumn + nextPair[1];
                if (!(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length)) {
                    continue;
                }
                if (visited[nr][nc] || grid[nr][nc] == 0) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
                count++;
            }
        }
        return count;
    }
}
