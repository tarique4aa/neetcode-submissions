class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for (int n : nums) {
            m.put(n, true);
        }
        for (int n : nums) {
            if (m.containsKey(n - 1)) {
                m.put(n, false);
            }
        }
        int ans = 0;
        for (int n : nums) {
            if (m.get(n)) {
                int s = n;
                int l = 1;
                while (m.containsKey(s + 1)) {
                    s++;
                    l++;
                }
                ans = Math.max(ans, l);
            }
        }
        return ans;
    }
}
