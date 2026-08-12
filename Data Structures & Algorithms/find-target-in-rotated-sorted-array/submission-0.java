class Solution {
    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;

        // Step 1: Find the pivot (minimum element)
        while (l < r) {
            int mid = l + (r - l) / 2; // Fixed line 7
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int p = r;
        r = nums.length - 1;
        l = 0;

        // Step 2: Binary search in the appropriate half
        if (nums[p] <= target && target <= nums[r]) {
            while (p <= r) {
                int mid = p + (r - p) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    p = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        } else {
            r = (p == 0) ? nums.length - 1 : p - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}