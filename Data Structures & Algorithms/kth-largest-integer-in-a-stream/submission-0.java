class KthLargest {

    PriorityQueue<Integer> q;
    int k; 
    public KthLargest(int k, int[] nums) {
         this.q = new PriorityQueue<>();
         this.k=k;
         for(int i=0;i<nums.length;i++){
            add(nums[i]);
         }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size()>k){
            q.poll();
        }
        return q.peek();
    }
}
