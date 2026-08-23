class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> t = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if(t.containsKey(target-nums[i])){
               ans[0] = t.get(target-nums[i]);
               ans[1] = i;
               return ans;
            }
            t.put(nums[i],i);
        }
        return ans;
    }
}
