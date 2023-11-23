class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int lSum = s(nums, 0, i - 1);
            int rSum = s(nums, i + 1, nums.length - 1);

            if (lSum == rSum) {
                return i;
            }
        }
        return -1;
    }

    private int s(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}