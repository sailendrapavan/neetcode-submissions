class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Integer[]{element, count});
            if(pq.size() > k) 
                pq.poll();
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
