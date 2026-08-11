class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid element is greater than rightmost element,
            // the minimum must be in the right half (excluding mid)
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                // Otherwise, the minimum is at mid or in the left half
                r = mid;
            }
        }

        return nums[l];
    }
}