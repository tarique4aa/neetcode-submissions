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
        Map<Integer, Integer> events = new TreeMap<>();
        for (Interval i : intervals) {
            events.put(i.start, events.getOrDefault(i.start, 0) + 1);
            events.put(i.end, events.getOrDefault(i.end, 0) - 1);
        }
        int over = 0, ans=0;
        for (Map.Entry<Integer, Integer> e : events.entrySet()) {
            over += e.getValue(); // Use e.getValue() instead of e.value
            ans = Math.max(ans, over);
        }
        return ans;
    }
}
