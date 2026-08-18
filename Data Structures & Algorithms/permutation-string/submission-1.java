class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int bn = s2.length(), sn = s1.length();
        if (sn > bn)
            return false;

        int[] s1f = new int[26];
        for (char c : s1.toCharArray()) {
            s1f[c - 'a']++;
        }

        int[] s2f = new int[26];
        int l = 0;
        int r = 0;
        while (r < bn) {
            s2f[s2.charAt(r) - 'a']++;
            if (r - l + 1 > sn) {
                s2f[s2.charAt(l) - 'a']--;
                l++;
            }
            if (Arrays.equals(s1f, s2f)) {
                return true;
            }
            r++;
        }
        return false;
    }
}
