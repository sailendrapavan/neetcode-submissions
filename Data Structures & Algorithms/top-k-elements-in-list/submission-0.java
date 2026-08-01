class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public int[] topKFrequent(int[] nums, int k) {
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        List<Integer>[] bucket = new List[nums.length+1];
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int element = entry.getKey();
            int value = entry.getValue();
            if (bucket[value] == null) {
			bucket[value] = new ArrayList<>();
		    }
            bucket[value].add(element);
        }

        List<Integer> res = new ArrayList<>();

        for(int pos = bucket.length - 1; pos >= 0 && res.size()<k;pos--){
            List<Integer> li = bucket[pos];
            if(li!=null) {
                int required = Math.min(li.size(),k-res.size());
                res.addAll(li.subList(0,required));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
