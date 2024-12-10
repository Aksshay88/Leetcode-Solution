class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[m];
        for(int i = 0; i < m; i++) 
            dp[i] = s.charAt(i) == t.charAt(n-1) ? 1 : 0;
        
        for(int j = n-2; j >= 0; j--) {
            int[] cur = new int[m];
            int suf = 0;
            char prevTChar = t.charAt(j+1);
            char TChar = t.charAt(j);
            for(int i = m-1; i >= 0; i--) {
                char SChar = s.charAt(i);
                cur[i] = SChar == TChar ? suf : 0;
                if(SChar == prevTChar) suf += dp[i];
            }
            dp = cur;
        }

        int ans = 0;
        for(int i = 0; i < m; i++) 
            ans += dp[i];
        
        return ans;
    }
}