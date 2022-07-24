class LRUCache {
    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
    }
    private void add(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void remove(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void move(DNode node) {
        remove(node);
        add(node);
    }
    private DNode poll() {
        DNode node = tail.prev;
        remove(node);
        return node;
    }
    private Map<Integer, DNode> map = new HashMap<>();
    private int capacity;
    private int size;
    private DNode head, tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DNode node = map.get(key);
        if (node==null) return -1;
        move(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        if (node==null) {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            add(newNode);
            size++;
            if (size>capacity) {
                DNode lru = poll();
                map.remove(lru.key);
                size--;
            }
        }
        else {
            node.value = value;
            move(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */