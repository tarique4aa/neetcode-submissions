class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;

        int[] lf_max = new int[n], rt_max = new int[n];

        lf_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            lf_max[i] = Math.max(lf_max[i - 1], height[i]);
        }

        rt_max[n-1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rt_max[i] = Math.max(rt_max[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int h = Math.min(lf_max[i], rt_max[i]) - height[i];

            ans += h;
        }

        return ans; 
    }
}
