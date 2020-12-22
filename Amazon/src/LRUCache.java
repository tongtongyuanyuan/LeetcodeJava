import java.util.HashMap;

class DNode {
    public DNode prev;
    public DNode next;
    public int key;

    public DNode(){
    }

    public DNode(DNode prev, DNode next, int key) {
        this.prev = prev;
        this.next = next;
        this.key = key;
    }
}
class LRUCache {
    HashMap < Integer, Integer > valMap;
    HashMap < Integer, DNode > nodeMap;

    int size;
    int maxCapacity;
    DNode head;
    DNode tail;

    public LRUCache(int capacity) {
        size = 0;
        valMap = new HashMap <>();
        nodeMap = new HashMap <>();
        maxCapacity = capacity;
        head = new DNode(null, tail, 0);
        tail = new DNode(head, null, 0);
    }

    public int get(int key) {
        Integer val = valMap.get(key);
        if (val != null) {
            DNode node = nodeMap.get(key);
            removeFromList(node); ///存在的话就把list里面原来对应的位置删除，从新加到list尾部
            addToList(node); //add the node to the last of the list
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        Integer storedVal = valMap.get(key);
        if (storedVal != null) {
            DNode node = nodeMap.get(key); //存在就remove, update新位置
            removeFromList(node);
        } else {
            size++;
            if (size > maxCapacity) {
                removeFirst();
            }
        }
        DNode newNode = new DNode(null, null, key);
        valMap.put(key, val);
        nodeMap.put(key, newNode); //存在这个val或者不存在都要进行这些操作，存在的时候，先删掉，
                                    //不存在的时候，判断size,不超过就直接addToFirst,超过的话就先删掉first one
        addToList(newNode);
    }

    public void addToList(DNode node) {  ////addToTail.新的在队尾，旧的在队首
        DNode oTail = tail.prev;
        oTail.next = node;
        node.prev = oTail;
        node.next = tail;
        tail.prev = node;
    }

    public void removeFromList(DNode node) {
        DNode prevNode = node.prev;
        DNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void removeFirst() {
        nodeMap.remove(head.next.key);
        valMap.remove(head.next.key);
        removeFromList(head.next);
        size--;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {

    }
}