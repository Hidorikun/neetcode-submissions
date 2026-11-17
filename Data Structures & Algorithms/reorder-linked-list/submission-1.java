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
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next;
            right = right.next;
        }
        
        right = revertList(left.next);
        left.next = null;

        ListNode a = head.next;
        ListNode b = right;
        ListNode curr = head;

        while (a != null || b != null) {
            if (b != null) {
                curr.next = b;
                curr = curr.next;
                b = b.next;
            }
            if (a != null) {
                curr.next = a;
                curr = curr.next;
                a = a.next;
            }
        }
    }

    private ListNode revertList(ListNode head) { 
        ListNode prev = null;
        ListNode current = head; 
        ListNode next; 
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
