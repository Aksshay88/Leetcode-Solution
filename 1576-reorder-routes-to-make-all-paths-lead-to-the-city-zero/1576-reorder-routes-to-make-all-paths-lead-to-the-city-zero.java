class Solution {
    public int minReorder(int n, int[][] connections) {
        final var visited = new boolean[n];
        final var nodes = new List[n];

        for(int[] conn: connections) {
            final var list1 = getOrDefault(nodes, conn[0]);
            final var list2 = getOrDefault(nodes, conn[1]);

            // Forward mapping
            list1.add(conn[1]);

            // Reverse mapping
            list2.add(-1 * conn[0]);
        }

        int result = 0;

        final Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            var node = q.poll();

            // Reverse mapping means it leads to 0, hence no change required
            if(node <= 0) {
                node *= -1;
            }else if(!visited[node]) {
                // Forward mapping means it moves away from 0, hence reverse this route if not visited already
                result++;
            }

            // Basic BFS graph logic
            if(!visited[node]) {
                visited[node] = true;
                q.addAll(nodes[node]);
            }
        }

        return result;
    }

    private List<Integer> getOrDefault(List<Integer>[] nodes, int index) {
        final var list = nodes[index] == null ? new ArrayList<Integer>(2) : nodes[index];
        return nodes[index] = list;
    }
}