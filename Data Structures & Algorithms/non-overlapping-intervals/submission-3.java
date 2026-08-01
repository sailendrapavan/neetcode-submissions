class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  
        int n = intervals.length;
        int count =0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<n;i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(curStart>=prevEnd){
                prevEnd = curEnd;
            }else {
                prevEnd = Math.min(curEnd,prevEnd);
                count++;
            }
        }
        return count;
    }
}
