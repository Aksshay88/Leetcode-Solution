class Solution {
    public int search(int[] nums, int target) {
        int pivot=findpivot(nums);
        if(pivot==-1){
            return binarysearch(nums,target,0,nums.length-1);
        }if(nums[pivot]==target){
            return pivot;   
        }if(target>=nums[0]){
            return binarysearch(nums,target,0,pivot-1);
        }else{
            return binarysearch(nums,target,pivot+1,nums.length-1);
        }
        
    }
    int findpivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(end>mid && arr[mid]>arr[mid+1]){
                return mid;
            }else if(start<mid && arr[mid]<arr[mid-1]){
                return mid-1;    
            }else if(arr[mid]<arr[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    int binarysearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}