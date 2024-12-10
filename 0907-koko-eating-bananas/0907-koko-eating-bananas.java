class Solution {
    // Helper function to check if it's possible to eat all bananas at speed possK within h hours
    private boolean isPossible(int[] piles, int possK, int h) {
        int totTime = 0;
        for (int i = 0; i < piles.length; i++)
            totTime += Math.ceil(piles[i] * 1d / possK); // Calculate time for each pile
        return totTime <= h; // Check if total time is within allowed hours
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; // Minimum possible eating speed
        int high = Integer.MIN_VALUE; // Maximum pile size (maximum eating speed)
        
        // Find the largest pile size for high value
        for (int pile : piles)
            high = Math.max(high, pile);

        int result = -1; // To store the minimum valid speed
        while (low <= high) {
            int mid = low + (high - low) / 2; // Middle speed (possible candidate)

            if (isPossible(piles, mid, h)) {
                result = mid; // Mid speed is valid, search for smaller speeds
                high = mid - 1;
            } else {
                low = mid + 1; // Mid speed is not enough, search for higher speeds
            }
        }

        return result; // Return the minimum valid speed
    }
}