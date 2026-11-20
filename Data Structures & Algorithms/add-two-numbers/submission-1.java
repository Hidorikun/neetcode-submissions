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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1; 
        ListNode b = l2; 
        ListNode head = new ListNode();
        int carry = 0;
        ListNode current = head;

        while (a != null || b != null) {

            int val = carry + 
                (a == null ? 0 : a.val) + 
                (b == null ? 0 : b.val);

            // calculate
            current.next = new ListNode(val % 10, null);
            current = current.next;
            carry = val / 10;

            //move a
            if (a != null) {
                a = a.next;
            }

            //move b
            if (b != null) {
                b = b.next;
            }
        }

        // reached the end but we can still have carry

        if (carry > 0) {
            current.next = new ListNode(carry, null);
        }

        return head.next;
    }
}
