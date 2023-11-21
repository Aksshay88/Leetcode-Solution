class Solution {
    public int countNicePairs(int[] nums) {
        int m=(int)Math.pow(10,9)+7;
        int c=0;
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long rev=reverse(nums[i]);
            long diff=nums[i]-rev;
            if(map.containsKey(diff)){
                c=(c%m + map.get(diff)%m)%m;
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        } 
     return c;
    }
    private long reverse(int num){
        long rev=0;
        while(num!=0){
            rev=rev*10 + num%10;
            num/=10;
        }
        return rev;
    }
}