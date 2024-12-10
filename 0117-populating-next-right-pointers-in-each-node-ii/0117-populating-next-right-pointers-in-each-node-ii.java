/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if(root == null) return null;
        Deque<Node> stack = new ArrayDeque<>();
        stack.offer(root);
        int len;
        while(!stack.isEmpty()) {
            len = stack.size();
            Node prev = null;
            for (int n = len; n > 0; --n) {
                Node current = stack.poll();
                if(prev != null) prev.next = current;
                prev = current;
                if(current.left != null) stack.offer(current.left);
                if(current.right != null) stack.offer(current.right);
            }
        }
        return root;
    }
}