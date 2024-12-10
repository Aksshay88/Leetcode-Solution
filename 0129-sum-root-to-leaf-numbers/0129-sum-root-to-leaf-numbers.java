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
    public int sumNumbers(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        int[] sum = {0};

        helper(root, 0, sum);

        return sum[0];

    }

    private static void helper(TreeNode root, int currentSum, int[] sum) {

        if (root == null) {
            return;
        }

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {

            sum[0] += currentSum;

            return;
        }

        helper(root.left, currentSum, sum);

        helper(root.right, currentSum, sum);
    }
}