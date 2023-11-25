class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length ;
        int rs  = 0;
        int ls = 0;
        int ts = 0 ;
        for(int i: nums) rs=rs+i;
        for(int i = 0 ; i <n ; i++){
            rs -=nums[i];
            ls+=nums[i];
            ts = Math.abs((i+1)*nums[i] - ls) + Math.abs((n-i-1)*nums[i]-rs);
            nums[i] =  ts;
        }
    return nums;
    }
}
