package hard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yixinxin on 17/2/26.
 *
 * use LinkedHashMap
 *
 * LinkedHashMap是HashMap的一个子类，它保留插入的顺序，如果需要输出的顺序和输入时的相同，那么就选用LinkedHashMap。
 * 根据链表中元素的顺序可以分为：按插入顺序的链表，和按访问顺序(调用get方法)的链表。
 *
 * 默认是按插入顺序排序，如果指定按访问顺序排序，那么调用get方法后，会将这次访问的元素移至链表尾部，不断访问可以形成按访问顺序排序的链表。  可以重写removeEldestEntry方法返回true值指定插入元素时移除最老的元素。
 * 在遍历的时候会比HashMap慢，不过有种情况例外，当HashMap容量很大，实际数据较少时，遍历起来可能会比 LinkedHashMap慢，因为LinkedHashMap的遍历速度只和实际数据有关，和容量无关，而HashMap的遍历速度和他的容量有关
 */
public class LRUCache2 {
    private Map<Integer, Integer> map;

    public LRUCache2(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!map.containsKey(key)) { return -1; }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }

    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {

        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            // 初始容量，加载因子，access-order
            // 后面如果需要增大长度，按照capacity*loadFactor取整后增长
            // <tt>true</tt> for access-order, <tt>false</tt> for insertion-order
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }

    public static void main(String[] args){
        LRUCache2 lruCache = new LRUCache2(2);

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
}
