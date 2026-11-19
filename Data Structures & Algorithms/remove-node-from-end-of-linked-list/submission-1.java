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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode current = head; 

        while (current != null) {
            size++;
            current = current.next;
        }

        ListNode prev = null; 
        current = head;

        if (size == n) {
            return head.next;
        }

        while (size > n) {
            prev = current;
            current = current.next;
            size--;
        }

        if (n == size) {
            prev.next = current.next;
        }

        return head;
    }
}
