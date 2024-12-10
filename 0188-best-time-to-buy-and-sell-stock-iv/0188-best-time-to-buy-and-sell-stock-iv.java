class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==0){
                        dp[idx][buy][cap]=Math.max(0+dp[idx+1][0][cap],-prices[idx]+dp[idx+1][1][cap]);
                    }
                    if(buy==1){
                        dp[idx][buy][cap]=Math.max(0+dp[idx+1][1][cap],prices[idx]+dp[idx+1][0][cap-1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}