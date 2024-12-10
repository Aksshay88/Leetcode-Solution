/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null){
            return null;
        }

        if(head.next==null){
            return new TreeNode(head.val);
        }

        // otherwise find mid and keep track of prev, to disconnect the LL
        ListNode dummy = new ListNode(-1);
        dummy.next=head;

        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=dummy;

        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        // now slow is at the mid and prev is one behind it

        if(prev!=null){
            prev.next=null;
        }  // disconnect root from left part


        TreeNode root= new TreeNode(slow.val); // make the middle node root
        
        root.left= sortedListToBST(head);  // design tree for LS of root where the head  is still the head of the original Linked List
        root.right=sortedListToBST(slow.next);  // recursively develop the rightSubtre for root, where head would be next of mid,i.e slow pointer
  
        slow.next=null;  // disconnect the root from the right part also


        return root;

       
        
        
    }
}