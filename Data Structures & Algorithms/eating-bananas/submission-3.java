class Solution {
    // Return long to avoid integer overflow when summing total hours
    private long getTime(int[] piles, int mid) {
        long t = 0;
        for (int pile : piles) {
            // Equivalent to ceil((double) pile / mid)
            t += (pile + mid - 1) / mid; 
        }
        return t;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        
        // Find the maximum pile size for the upper bound
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long hr = getTime(piles, mid);
            
            if (hr <= h) {
                ans = mid;
                r = mid - 1; // Try finding a smaller valid speed
            } else {
                l = mid + 1; // Speed is too slow, increase speed
            }
        }
        return ans;
    }
}