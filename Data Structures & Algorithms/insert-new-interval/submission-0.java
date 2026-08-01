class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> copy = new ArrayList<>();
        boolean isNewIntervalAdded = false;
        int i =0;
        int n = intervals.length;
        while(i<n && intervals[i][0] < newInterval[0]){
            copy.add(intervals[i]);
            i++;
        }
        copy.add(newInterval);

        while(i<n){
            copy.add(intervals[i]);
            i++;
        }

        List<int[]> res = new ArrayList<>();
        res.add(copy.get(0));
        for(int[] interval : copy ){
            int [] oldInterval = res.get(res.size()-1);
            int previousend =  oldInterval[1];
            int currStart = interval[0];
            int currEnd = interval[1];
            if(currStart<=previousend){
                oldInterval[1] = Math.max(previousend,currEnd);
            }else{
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    } 


    



}
