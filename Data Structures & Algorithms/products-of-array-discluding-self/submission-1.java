class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro = 1;
        int z = 0;
        int proz = 1;

        for (int n : nums) {
            pro *= n;
            if (n == 0) {
                z++;
            }
            if (n != 0) {
                proz *= n;
            }
        }
        int n = nums.length;
        int[] ans = new int[n];
        if (z >= 2)
            return ans;
        else if (z == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    ans[i] = proz;
                }
            }
            return ans;
        }
        int i = 0;
        for (int x : nums) {
            ans[i++]=pro/x;
        }
        return ans;
    }
}
