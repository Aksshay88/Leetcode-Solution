/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    private int max_gain(TreeNode node) {
        if (node == null) return 0;

        // Maximum gain from left and right subtrees
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // Price of the new path
        int price_new_path = node.val + left_gain + right_gain;

        // Update global max_sum if the new path is better
        max_sum = Math.max(max_sum, price_new_path);

        // Return the max gain if the path continues through the parent
        return node.val + Math.max(left_gain, right_gain);
    }
}