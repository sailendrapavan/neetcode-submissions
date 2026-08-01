/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
      Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));
      if(intervals.size()==0){
        return true;
      }
      int prevend= intervals.get(0).end;
      int n = intervals.size();
      for (int i = 1;i<n;i++){
         int curstart = intervals.get(i).start;
         if(curstart<prevend){
            return false;
         }else{
            prevend = intervals.get(i).end;
         }
      }
      return true;
    }
}
