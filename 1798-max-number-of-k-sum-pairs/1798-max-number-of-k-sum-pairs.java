class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == k) {
                i++;
                j--;
                ans++;
            } else if (temp > k) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}