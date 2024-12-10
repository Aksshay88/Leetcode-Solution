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
 class BSTIterators {
    Stack<TreeNode> st = new Stack<>();
    Boolean reverse;

    public BSTIterators(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        insertAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        if (reverse == false) {
            insertAll(temp.right);
        } else {
            insertAll(temp.left);
        }
        return temp.val;

    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void insertAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterators lt = new BSTIterators(root, false);
        BSTIterators rt = new BSTIterators(root, true);
        int i = lt.next();
        int j = rt.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = lt.next();
            } else {
                j = rt.next();
            }
        }
        return false;
    }
}