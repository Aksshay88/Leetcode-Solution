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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode();
        ListNode greatHead= new ListNode();
        ListNode less=lessHead; 
        ListNode great=greatHead;
        ListNode current=head; 
        while(current!=null){
            if(current.val<x){
                less.next=current;
                less=less.next;
              }
            else{ 
            great.next=current;
               great=great.next;
            }
            current=current.next;
            }
            great.next=null; 
            less.next=greatHead.next;
            return lessHead.next;

       
        
        
    }
}