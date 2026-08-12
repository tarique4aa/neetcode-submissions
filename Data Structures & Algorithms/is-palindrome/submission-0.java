class Solution {
    public boolean isPalindrome(String s) {
        String n = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0, r = n.length() - 1;
        while (l < r) {
            if (n.charAt(l) != n.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;
    }
}
