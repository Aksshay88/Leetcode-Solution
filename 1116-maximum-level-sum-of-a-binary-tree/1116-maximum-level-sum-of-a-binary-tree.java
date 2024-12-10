class Solution {
    public int maxLevelSum(TreeNode root) {
        TreeNode[] queue = new TreeNode[100001];  // Queue for BFS
        int head = 0;  // Points to the node we are currently processing
        int tail = 0;  // Points to the next free space in the queue

        int maxSum = Integer.MIN_VALUE;  // To store the maximum sum encountered
        int maxLevel = 0;  // To store the level with the maximum sum

        queue[tail++] = root;  // Start BFS by adding the root node to the queue
        int level = 1;  // Start at level 1

        // BFS loop
        while (head < tail) {
            int count = tail - head;  // Number of nodes at the current level
            int tempSum = 0;  // Sum of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue[head++];  // Get the next node
                tempSum += currentNode.val;  // Add its value to the sum

                // Add its children (next level) to the queue
                if (currentNode.left != null) {
                    queue[tail++] = currentNode.left;
                }

                if (currentNode.right != null) {
                    queue[tail++] = currentNode.right;
                }
            }

            // Update maxSum and maxLevel if this level's sum is greater
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxLevel = level;
            }

            level++;  // Move to the next level
        }

        return maxLevel;  // Return the level with the maximum sum
    }
}