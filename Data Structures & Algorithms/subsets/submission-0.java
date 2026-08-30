class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        solve(nums, 0, nums.length);
        return ans;
    }

    public void solve(int[] nums, int i, int n) {
        if (i == n) {
            ans.add(new ArrayList<>(temp)); // Store a copy of the current subset
            return;
        }

        // 1. Include nums[i]
        temp.add(nums[i]);
        solve(nums, i + 1, n);

        // 2. Backtrack (undo the include decision)
        temp.remove(temp.size() - 1);

        // 3. Exclude nums[i]
        solve(nums, i + 1, n);
    }
}