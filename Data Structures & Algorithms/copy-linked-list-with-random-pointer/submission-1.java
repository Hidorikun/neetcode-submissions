/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>(); 

        Node current = head;
        while (current != null) {
            Node currentCopy = copy.computeIfAbsent(current, k -> new Node(k.val));

            // set next
            currentCopy.next = (current.next != null)
                ? copy.computeIfAbsent(current.next, k -> new Node(k.val))
                : null;

            // set random
            currentCopy.random = (current.random != null)
                ? copy.computeIfAbsent(current.random, k -> new Node(k.val))
                : null;

            //move on
            current = current.next;
        }

        return copy.get(head);
    }
}
