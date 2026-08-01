class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>((a, b) ->
                ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])));

        for (int[] point : points) {
            minHeap.offer(new Integer[]{point[0], point[1]});
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Integer[] cur = minHeap.poll();
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }
        return res;

    }
}
