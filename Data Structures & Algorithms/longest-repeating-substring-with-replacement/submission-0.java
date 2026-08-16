class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Expand the window by adding the current character
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;

            // Update the maximum frequency seen in any window so far
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            // If the number of characters to replace exceeds k, shrink the window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum valid window length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
