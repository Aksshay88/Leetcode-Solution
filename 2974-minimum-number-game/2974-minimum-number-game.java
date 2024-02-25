class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length ;
        int res[] = new int[n] ;
        Arrays.sort(nums);
        for(int i=0 ; i<n ; i=i+2){
                res[i+1]=nums[i] ;
                res[i] = nums[i+1] ;
        }
        return res ;
    }
}