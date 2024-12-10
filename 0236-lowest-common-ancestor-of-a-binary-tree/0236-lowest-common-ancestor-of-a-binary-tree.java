/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);

        //case 1 if p and q present in left subtree the right subtree will return the null value
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca; //this case is for p & q present in right subtree
        }
        return root; // this case is for the  p & q are present on the either side left and right subtree
    }
}