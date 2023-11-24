class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int s=0;
        int a=piles.length;
        for(int i=a/3;i<a;i+=2){
            s+=piles[i];
            }
            return s;
    }
}