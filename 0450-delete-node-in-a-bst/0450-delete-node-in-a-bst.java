class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return help(root);
        }

        TreeNode ans = root;
        
        while (root != null) {
            if (root.val > key) {
              
                if (root.left != null && root.left.val == key) {
                    root.left = help(root.left);
                    break;
                
                } else {
                    root = root.left;
                }
            
            } else {
            
                if (root.right != null && root.right.val == key) {
                    root.right = help(root.right);
                    break;
                } else {
            
                    root = root.right;
                }
            }
        }
        
        return ans;
    }

    private TreeNode help(TreeNode root) {
        
        if (root.left == null) {
            return root.right;
        
        } else if (root.right == null) {
            return root.left;
        
        } else {
            TreeNode rightone = root.right;
            TreeNode lastright = find(root.left);
        
            lastright.right = rightone;
        
            return root.left;
        }
    }

    private TreeNode find(TreeNode root) {
        
        if (root.right == null) {
            return root;
        }
        
        return find(root.right);
    }
}