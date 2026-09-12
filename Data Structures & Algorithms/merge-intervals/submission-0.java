class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 0)
            return ans.toArray(new int[ans.size()][]);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        int i = 0;
        if (intervals.length == 1)
            return ans.toArray(new int[ans.size()][]);
        for (int j = 1; j < intervals.length; j++) {
            if (ans.get(i)[1] >= intervals[j][0]) {
                ans.get(i)[1] = Math.max(ans.get(i)[1], intervals[j][1]);
            }else{
                ans.add(intervals[j]);
                i++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
