class Solution {
    public int numberOfWays(String corridor) {
        int x = 1;
        int y = 0; 
        int z = 0; 
        int m = (int)1e9 + 7;
        for (int i = 0; i < corridor.length(); ++i)
            if (corridor.charAt(i) == 'S') {
                x = (x + z) % m;
                z = y; 
                y = x;
                x = 0;
            } else {
                x = (x + z) % m;
            }
        return z;
    }
}