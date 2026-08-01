class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char c : tasks) {
            frequency[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int fre : frequency) {
            if (fre > 0) {
                maxHeap.add(fre);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time = time + 1;
            if (!maxHeap.isEmpty()) {
                int leftFrequency = maxHeap.poll() - 1;
                if (leftFrequency > 0) {
                    queue.add(new int[]{leftFrequency, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
