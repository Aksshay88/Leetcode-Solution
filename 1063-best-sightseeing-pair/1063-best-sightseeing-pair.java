class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int n = values.length;
        int val = values[0];
        for (int i = 1; i < n; i++) { 
            ans = Math.max(ans , values[i] + val-1);
            val = Math.max(values[i] , val-1);
        }
        return ans;
    }
}