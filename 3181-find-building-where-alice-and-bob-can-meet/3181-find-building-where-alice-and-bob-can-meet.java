import java.util.*;
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<int[]>> qs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            qs.add(new ArrayList<>());
        }
        for (int index = 0; index < queries.length; index++) {
            int alice = queries[index][0];
            int bob = queries[index][1];
            if (alice > bob) {
                int temp = alice;
                alice = bob;
                bob = temp;
            }
            if (alice == bob || heights[alice] < heights[bob]) {
                result[index] = bob;
            } else {
                qs.get(bob).add(new int[]{heights[alice], index});
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int index = 0; index < n; index++) {
            int height = heights[index];
            for (int[] q : qs.get(index)) {
                minHeap.add(q);
            }
            while (!minHeap.isEmpty() && minHeap.peek()[0] < height) {
                int[] query = minHeap.poll();
                int queryIndex = query[1];
                result[queryIndex] = index;
            }
        }
        return result;
    }
}
