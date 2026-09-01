

class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        
        // 1. Sort candidates to group duplicates together
        Arrays.sort(candidates);
        
        backtrack(candidates, 0, target);
        return ans;
    }

    private void backtrack(int[] nums, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 2. Skip duplicate elements at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // 3. Stop exploring if the current element exceeds the remaining target
            if (nums[i] > target) break;

            temp.add(nums[i]);
            backtrack(nums, i + 1, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}