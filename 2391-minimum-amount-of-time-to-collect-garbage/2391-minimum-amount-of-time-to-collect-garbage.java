class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, k = 0, pickupTime = 0;
        int[] prefixSum = new int[n];
        for (int t : travel) {
            prefixSum[k + 1] = prefixSum[k++] + t;
        }
        Map<Character, Integer> truckToTime = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pickupTime += garbage[i].length();
            for (char c : garbage[i].toCharArray()) {
                truckToTime.put(c, prefixSum[i]);
            }
        }
        return pickupTime + truckToTime.values().stream().mapToInt(i -> i).sum();
    }
}