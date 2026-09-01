class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        solve(nums, 0);
        return ans;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void solve(int[] nums, int pos) {
        if (pos >= nums.length) {
           List<Integer> current = new ArrayList<>();
            for (int n : nums) {
                current.add(n);
            }
            ans.add(current);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            swap(nums, i , pos);
            solve(nums, pos+1);
            swap(nums, i, pos);
        }
    }
}
