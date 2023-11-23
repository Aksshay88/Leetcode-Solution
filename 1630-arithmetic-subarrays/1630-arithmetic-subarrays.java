class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res=new ArrayList();
        for(int i=0;i<l.length;i++){
            int[] arr=new int[r[i]-l[i]+1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }
            
            res.add(check(arr));
        }

        return res;
    }
    public Boolean check(int[] arr){
        Arrays.sort(arr);
        int sub=arr[1]-arr[0];
        for(int i=2;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=sub){
                return false;
            }
        }
        return true;
        
    }
}