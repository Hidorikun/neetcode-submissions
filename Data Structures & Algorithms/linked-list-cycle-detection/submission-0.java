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
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();

        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }

            map.put(head, true);
            head = head.next;
        }

        return false;
    }
}
