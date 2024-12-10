class Solution {
    public int binaryGap(int n) {
        String str=Integer.toString(n,2);
        char[] ar=str.toCharArray();
       int max=0,c=0;
        for(int i=1;i<ar.length;i++){
            if(ar[i]=='1'){
               int maxy=(int)(Math.abs(c-i));
               if(max<maxy){
                   max=maxy;
               }
               c=i;

            }
        }
        return max;
    }
}