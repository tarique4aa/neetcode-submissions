class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length - 1;
        int m = 0;
        while (m < n) {
            if (numbers[m] + numbers[n] == target) {
                return new int[]{m+1, n+1};
            }else if(numbers[m] + numbers[n] > target){
                n--;
            }else{
                m++;
            }
        }
        return new int[0];
    }
}
