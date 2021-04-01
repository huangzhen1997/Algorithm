import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {

    HashMap<Integer,Integer> cache;
    int size;
    Queue<Integer> queue;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        queue = new LinkedList<>();
        size = capacity;
    }

    public int get(int key) {
        if(this.cache.containsKey(key)){
            //remove the key item from the queue, and add it to the tail; 
            this.queue.remove(key);
            queue.offer(key);
            return cache.get(key);
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {

        if(this.cache.containsKey(key)){
            this.queue.remove(key);
            this.cache.remove(key);

        }

        else if (this.cache.size()==this.size){
            int expired = queue.remove();
            this.cache.remove(expired);
        }

        this.cache.put(key,value);
        this.queue.offer(key);
    }

    public static void main(String[] args){
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */