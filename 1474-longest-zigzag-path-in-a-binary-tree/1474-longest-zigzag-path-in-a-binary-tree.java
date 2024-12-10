
class Solution {
    int MAX;
    Map<TreeNode, int []> dp;
    public int longestZigZag(TreeNode root) {
        dp = new HashMap<>();
        dfs(root);
        return MAX;
    }
    private void dfs(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            dp.put(root, new int[]{0,0});
            return;
        }
        dfs(root.left);
        dfs(root.right);

        int left = 0, right = 0;

        if(dp.get(root.left) != null)
            left = 1 + dp.get(root.left)[1]; 
        
        if(dp.get(root.right) != null)
            right = 1 + dp.get(root.right)[0];
        dp.put(root, new int[]{left, right});
        MAX = Math.max(MAX, Math.max(left,right));
    }
}