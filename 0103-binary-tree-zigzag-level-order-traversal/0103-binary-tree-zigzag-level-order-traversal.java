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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> l1= new ArrayList<>();
        if (root==null){
            return l1;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n= q.size();
            List<Integer> temp= new ArrayList<>();
            for (int i=0;i<n;i++){
                TreeNode current = q.poll();
                temp.add(current.val);
                if (current.left!=null){
                    q.offer(current.left);
                }
                if (current.right!=null){
                    q.offer(current.right);
                }
            }
        l1.add(temp);
        }

        for (int i=1;i<l1.size();i=i+2){
            Collections.reverse(l1.get(i));
        }
        return l1;

    }
}