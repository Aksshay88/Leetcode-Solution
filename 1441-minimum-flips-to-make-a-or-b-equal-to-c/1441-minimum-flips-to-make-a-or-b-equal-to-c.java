class Solution {
    public int minFlips(int a, int b, int c) {
        int operations = 0;
        while (a > 0 || b > 0 || c > 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    operations++;
                }
            } else {
                if ((a & 1) == 1) {
                    operations++;
                }
                if ((b & 1) == 1) {
                    operations++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return operations;
    }
}