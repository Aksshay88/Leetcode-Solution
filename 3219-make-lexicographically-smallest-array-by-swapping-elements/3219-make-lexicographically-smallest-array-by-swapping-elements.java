import java.util.*;
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[][] sortedPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i];
            sortedPairs[i][1] = i;
        }
        Arrays.sort(sortedPairs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[n];
        int groupStart = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || sortedPairs[i+1][0] - sortedPairs[i][0] > limit) {
                List<Integer> indices = new ArrayList<>();
                for (int j = groupStart; j <= i; j++) 
                    indices.add(sortedPairs[j][1]);
                Collections.sort(indices);
                for (int j = 0; j < indices.size(); j++) 
                    result[indices.get(j)] = sortedPairs[groupStart + j][0];
                
                groupStart = i + 1;
            }
        }
        return result;
    }
}