class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(nums[mid]<nums[e]){
                e=mid;
            }else{
                s=mid+1;
            }
        }
        return nums[s];
    
    }
}