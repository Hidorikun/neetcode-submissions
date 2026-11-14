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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = list1;
        ListNode b = list2;
        
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        ListNode head; 
        
        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else { 
            head = b;
            b = b.next;
        }

        ListNode curr = head;

        while (a != null && b != null) {
            //next one is min between a b
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        // one of them is null so simply add the othe

        curr.next = (a == null) ? b : a;

        return head;
    }
}