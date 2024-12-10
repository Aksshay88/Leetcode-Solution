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
    public int goodNodes(TreeNode root) {
        int count[] = {0};
        int pathMax = root.val;
        getGoodNodes(root,pathMax,count);
        return count[0];
    }
    public void getGoodNodes(TreeNode root,int pathMax,int count[]){
        if(root == null){
            return;
        }
        pathMax = Math.max(pathMax,root.val);
        if(pathMax == root.val){
            count[0]++;
        }
        getGoodNodes(root.left,pathMax,count);
        getGoodNodes(root.right,pathMax,count);
    }
}