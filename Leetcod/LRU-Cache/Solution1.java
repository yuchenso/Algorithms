import java.util.*;
public class LRUCache {
    Map <Integer, Integer> map;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }
        else {
            map.put(key, value);
        }
    }
}
