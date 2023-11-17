class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i:nums){
            if(i==target){
                return true;
            }
        }
        return false;
    }
}