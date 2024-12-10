class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0, n = nums.length, i, j, k;
        for(i = 0; i<n ; i++) {
            for(j = i+1, k = j+1; j<(n - 1) && k<=n;) {
                if(k == n || nums[i]+nums[j] <= nums[k]){
                    if(k > (j+1))
                        res += k - j - 1;
                    j++;
                }else k++;
            }
        }
        return res;
    }
}