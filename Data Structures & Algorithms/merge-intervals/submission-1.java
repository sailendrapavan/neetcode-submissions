class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            int [] oldInterval = output.get(output.size()-1);
            int previousStart = oldInterval[0];
            int previousend =  oldInterval[1];
            if(start<=previousend){
                oldInterval[1] = Math.max(end,previousend);
            }else{
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
