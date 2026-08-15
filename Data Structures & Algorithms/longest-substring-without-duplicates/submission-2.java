class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> u = new HashSet<>();
        int ans = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (u.contains(s.charAt(right))) {
                u.remove(s.charAt(left));
                left++;
            }
            u.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
