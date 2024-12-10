class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max1 =nums[0];
        int min =nums[0];
        int sum1=0;
        int sum2 =0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
        sum+=nums[i];
       sum1+= nums[i];
       sum2+=nums[i];
       max1 = Math.max(sum1,max1);
       min= Math.min(sum2,min);
       if(sum1<0){
         sum1 =0;
       }
       if(sum2>0){
         sum2 =0;
       }
        }
      if(sum-min ==0) {
        return max1;
      } 
 return Math.max(max1,sum-min);   }
}