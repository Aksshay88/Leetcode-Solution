class Solution {

    private Map<Long, Integer> hmap;
    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        if (root == null) return;
        
        prefixSum += root.val;
        
        if (hmap.containsKey(prefixSum-targetSum)) 
            count += hmap.get(prefixSum-targetSum); 
        
        if (targetSum == prefixSum) 
            count++;

        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        hmap.put(prefixSum, hmap.get(prefixSum) - 1);
    }
}