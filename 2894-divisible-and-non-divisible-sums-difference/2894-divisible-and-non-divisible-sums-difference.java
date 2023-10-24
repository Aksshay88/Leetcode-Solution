class Solution {
    public int differenceOfSums(int n, int m) {
        int output=0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                output-=i;
            }else{
                output+=i;
            }
        }
        return output;
    }
}