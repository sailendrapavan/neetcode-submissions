class Solution {
    public int orangesRotting(int[][] grid) {
        int count = -1;
        boolean freshFruit = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } if(!freshFruit && grid[i][j] == 1){
                     freshFruit = true;
                }
            }
        }
        if(!freshFruit){
            return 0;
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});
        list.add(new int[]{0, 1});
        list.add(new int[]{-1, 0});
        list.add(new int[]{0, -1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cr = current[0];
                int cc = current[1];
                for (int[] ele : list) {
                    int nr = ele[0] + cr;
                    int nc = ele[1] + cc;
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            queue.add(new int[]{nr, nc});
                        }
                        
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
