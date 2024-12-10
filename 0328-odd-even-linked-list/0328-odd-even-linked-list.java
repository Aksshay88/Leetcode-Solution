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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //cornor cases
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head; //for odd
        ListNode even = head.next; //for even node
        ListNode Ehead = even; ///head of even which will help in the merging of odd even list 

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even  = even.next;
        }
        odd.next = Ehead; //connect the odd list with the even list
        return head;
    }
}