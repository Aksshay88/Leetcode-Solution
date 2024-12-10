class Solution {
    public ListNode deleteMiddle(ListNode head) {

        // Handle edge cases: empty list or single-node list
        if (head == null || head.next == null) {
            return null;
        }

        // Step 1: Find the total length of the list
        ListNode Ltemp = head;
        int TLength = 0;
        while (Ltemp != null) {
            Ltemp = Ltemp.next;
            TLength++;
        }

        // Step 2: Traverse again to find the middle node
        ListNode ATemp = null;
        ListNode TTemp = head;
        int ALength = 0;
        int mid = TLength / 2;
        while (TTemp != null) {
            // Step 3: Delete the middle node by adjusting pointers
            if (ALength == mid) {
                ATemp.next = TTemp.next;
                ALength++;
            } else {
                ATemp = TTemp;
                TTemp = TTemp.next;
                ALength++;
            }
        }

        return head; // Return the modified head after deleting the middle node
    }
}