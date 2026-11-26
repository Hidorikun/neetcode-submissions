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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;

        ListNode start = head;
        ListNode curr = head;
        ListNode dummyHead = new ListNode(); 
        ListNode sequenceEnd = dummyHead;

        while (curr != null) {
            if (count == k) {
                ListNode next = curr.next;
                reverse(start, curr);
                sequenceEnd.next = curr;
                sequenceEnd = start;
                sequenceEnd.next = next;
                curr = next;
                start = next;
                count = 1;
            } else {
                count++;
                curr = curr.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        end.next = prev;
        return end;
    }
}
