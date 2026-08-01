class Solution {
    public int lastStoneWeight(int[] stones) {
               PriorityQueue<Integer> queu = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queu.add(stone);
        }
        while (queu.size() >= 2) {
            int stone1 = queu.poll();
            int stone2 = queu.poll();
            if (stone1 > stone2) {
                queu.add(stone1 - stone2);
            } else if (stone2 > stone1) {
                queu.add(stone2 - stone1);
            }
        }
        if (queu.isEmpty()) {
            return 0;
        } else {
            return queu.poll();
        }      
        
    }
}
