class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> hm = new HashMap<>();
        int n = grid.length;
        for(int i=0;i<n;++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;++j){
                sb.append('0'+grid[i][j]);
            }
            String s = sb.toString();
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        int ans=0;
        for(int i=0;i<n;++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;++j){
                sb.append('0'+grid[j][i]);
            }
            String s = sb.toString();
            ans += hm.getOrDefault(s,0);
        }
        return ans;
    }
}