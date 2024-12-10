class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }
        
        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;  // Avoid duplicate words
        }

        board[i][j] = '#';
        int[] dirs = {-1, 0, 1, 0, -1};  // Directions for DFS (up, right, down, left)
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d], nj = j + dirs[d + 1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                dfs(board, ni, nj, node, result);
            }
        }
        board[i][j] = c;  // Restore cell
    }
}