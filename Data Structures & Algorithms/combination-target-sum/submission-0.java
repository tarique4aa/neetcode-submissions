class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        int sum = 0;
        // Arrays.sort(nums);
        help(nums, 0, sum, target);
        return ans;
    }

    public void help(int[] nums, int i, int s, int t) {
        if (s == t) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (s > t)
            return;

        if (i >= nums.length)
            return;

        // skip the ith element
        help(nums, i + 1, s, t);

        s += nums[i];
        temp.add(nums[i]);
        // take the ith element
        help(nums, i, s, t);
        s -= nums[i];
        temp.remove(temp.size()-1);
    }
}
