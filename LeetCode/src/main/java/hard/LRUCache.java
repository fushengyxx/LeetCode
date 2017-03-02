package hard;

import java.util.Hashtable;

/**
 * Created by yixinxin on 17/2/25.
 * <p>
 * 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );  //capacity
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    /**
     * The "tail" is the pseudo node that marks the boundary of the tail, same as that the "head" node is a pseudo
     * node that marks the head. The double linked list can be represented as head (pseudo) <--> head <--> ....tail
     * <--> tail (pseudo).
     *
     * By adding two pseudo nodes to make the boundaries, we could reduce the boundary checking code such as if (head
     * != null), making the code more concise and also more efficient.
     */
    public class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode post;
    }

    /**
     * Always add the new node right after head
     */
    private void addNode(DoubleLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list
     *
     * @param node
     */
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head
     */
    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * Pop the current tail
     */
    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DoubleLinkedNode> cache =
            new Hashtable<Integer, DoubleLinkedNode>();
    private int count;
    private int capacity;
    private DoubleLinkedNode head, tail;

    /**
     * set head and tail as empty point which simple the add and remove operation
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        head.pre = null;

        tail = new DoubleLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here
        }

        // get the value, move it the the head
        // move the accessed node to the head
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            // cache的容量有限制，但double linked list 和hashtable的容量可以比cache容量大
            if (count > capacity) {
                // pop the tail
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
