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
    public int pairSum(ListNode head) {
        if(head.next == null) return head.val;
        if(head.next.next == null) return head.val + head.next.val;
        int len = 0;
        ListNode t = head;
        while(t!=null){
            len++;
            t=t.next;
        }
        System.out.println(len);
        int[] arr = new int[(len/2)];
        int i = 0;
        int j =1;
        t = head;
        while(t != null){
            if(i > arr.length-1){
                arr[i-j] = arr[i-j] + t.val;
                System.out.println(arr[i-j]);
                j = j+2;
            }else{
                arr[i] = t.val;
            }
            i++;
            t=t.next;
        }
        System.out.println(arr);
        int max = Integer.MIN_VALUE;
        for(int k=0;k<arr.length;k++){
            if(max<arr[k]) max = arr[k];
        }
        return max;
        
    }
}