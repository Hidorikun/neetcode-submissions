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
            if (!copy.containsKey(current)) {
                copy.put(current, new Node(current.val));
            }

            Node currentCopy = copy.get(current);

            // set next
            if (current.next == null) {
                currentCopy.next = null;
            } else {
                if (!copy.containsKey(current.next)) {
                    copy.put(current.next, new Node(current.next.val));
                }

                currentCopy.next = copy.get(current.next);
            }

            // set random
            if (current.random == null) {
                currentCopy.random = null;
            } else {
                if (!copy.containsKey(current.random)) {
                    copy.put(current.random, new Node(current.random.val));
                }

                currentCopy.random = copy.get(current.random);
            }

            //move on
            current = current.next;
        }

        return copy.get(head);
    }
}
