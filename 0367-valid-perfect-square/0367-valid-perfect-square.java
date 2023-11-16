class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num){
                return true;
            }
            if (mid * mid < num) { 
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return false;
    }
}