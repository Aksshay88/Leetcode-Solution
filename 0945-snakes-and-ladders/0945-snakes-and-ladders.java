class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // flatten the board into a 1D array
        int[] flatBoard = new int[n * n + 1];
        boolean leftToRight = true;
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flatBoard[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flatBoard[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        // BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.add(1);
        visited[1] = true;
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return moves;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    if (flatBoard[next] != -1) {
                        next = flatBoard[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}