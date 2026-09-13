class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       // 1. Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        // 2. Iterate through intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap found: remove current interval
                count++;
            } else {
                // No overlap: update the end position
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
