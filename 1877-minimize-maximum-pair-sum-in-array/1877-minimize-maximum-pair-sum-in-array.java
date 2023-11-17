class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int m=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            m=Math.max(m,(nums[i++] + nums[j--]));
        }
        return m;
    }
}

