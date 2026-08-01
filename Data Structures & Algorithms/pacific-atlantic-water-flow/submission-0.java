class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        HashSet<AbstractMap.Entry> pacific = new HashSet<>();
        HashSet<AbstractMap.Entry> atlantic = new HashSet<>();

        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(rows - 1, i, atlantic, heights[rows - 1][i], heights);
        }

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, heights[i][0], heights);
            dfs(i, cols - 1, atlantic, heights[i][cols - 1], heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (AbstractMap.Entry<Integer, Integer> entry : pacific) {
            if (atlantic.contains(entry)) {
                ans.add(Arrays.asList(entry.getKey(), entry.getValue()));
            }
        }
        return ans;
    }



    private void dfs(int row, int column, HashSet<AbstractMap.Entry> set, int prevHeight, int[][] matrix) {
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length) {
            return;
        }
        if (matrix[row][column] < prevHeight) {
            return;
        }
        if(set.contains(new AbstractMap.SimpleEntry<>(row, column))){
            return;
        }
        set.add(new AbstractMap.SimpleEntry<>(row, column));
        dfs(row + 1, column, set, matrix[row][column], matrix);
        dfs(row, column + 1, set, matrix[row][column], matrix);
        dfs(row - 1, column, set, matrix[row][column], matrix);
        dfs(row, column - 1, set, matrix[row][column], matrix);
    }
}
