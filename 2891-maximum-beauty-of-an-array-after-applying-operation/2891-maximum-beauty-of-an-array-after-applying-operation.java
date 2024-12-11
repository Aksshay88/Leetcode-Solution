class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        int[] range = new int[maxValue + 10];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, nums[i] - k);
            int right = Math.min(maxValue, nums[i] + k) + 1;
            range[left]++;
            range[right]--;
        }
        int result = range[0];
        for (int i = 1; i < range.length; i++) {
            range[i] += range[i - 1];
            if (range[i] > result) {
                result = range[i];
            }
        }
        return result;
    }
}