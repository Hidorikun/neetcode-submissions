class LRUCache {

    // doubly linked list
    class Node {
        public Integer key;
        public Integer value;
        public Node prev;
        public Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    Node left = new Node();
    Node right = new Node();

    // hashmap
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node nodeToRemove = left.next;
            map.remove(nodeToRemove.key);
            remove(nodeToRemove);
        }

    }

    private void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}
