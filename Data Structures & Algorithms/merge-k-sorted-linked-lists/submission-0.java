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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeRecursive(lists, 0, lists.length - 1);
    }

    // left and right are inclusive
    private ListNode mergeRecursive(ListNode[] lists, int left, int right) {
        if (right < left) {
            return null;
        }
        
        if (left == right) {
            return lists[left];
        }

        int mid  = left + (right - left) / 2;
        return merge(mergeRecursive(lists, left, mid), mergeRecursive(lists, mid + 1, right));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        while (a != null) {
            curr.next = a;
            a = a.next;
            curr = curr.next;
        }

        while (b != null) {
            curr.next = b;
            b = b.next;
            curr = curr.next;
        }

        curr.next = null;
        return dummy.next;
    }
}
