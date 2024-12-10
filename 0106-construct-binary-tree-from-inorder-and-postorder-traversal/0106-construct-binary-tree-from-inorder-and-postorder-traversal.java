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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return fun(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode fun(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd,
            HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inIndex = map.get(root.val);
        int leftTreeSize = inIndex - inStart;

        root.left = fun(inOrder, inStart, inIndex - 1, postOrder, postStart, postStart + leftTreeSize - 1, map);
        root.right = fun(inOrder, inIndex + 1, inEnd, postOrder, postStart + leftTreeSize, postEnd - 1, map);
        return root;
    }
}
