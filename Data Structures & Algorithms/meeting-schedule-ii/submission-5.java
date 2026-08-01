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
    public int minMeetingRooms(List<Interval> intervals) {
    Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));
    int count =1;
    if(intervals.size()==0){
        return 0;
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    minHeap.add(intervals.get(0).end);
    int n = intervals.size();
    for(int i =1;i<n;i++){
        int currentMeetingStartTime = intervals.get(i).start;
        int currentEndTime = intervals.get(i).end;
        if(currentMeetingStartTime<minHeap.peek()){
              count++;
              minHeap.add(currentEndTime);
        }else{
              minHeap.poll();
              minHeap.add(currentEndTime);
        }
        
    }
    return count;

 }
}
