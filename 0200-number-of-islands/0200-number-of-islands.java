class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    islands++;
                    bfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }

        return islands;        
    }

    private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        visited.add(r + "," + c);
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] direction : directions) {
                int nr = row + direction[0], nc = col + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                    q.add(new int[]{nr, nc});
                    visited.add(nr + "," + nc);
                }
            }
        }
    }    
}