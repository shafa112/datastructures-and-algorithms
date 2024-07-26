package datastructure.map.lrucache.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap extends LinkedHashMap {

    int cacheSize;

    public LRUCacheUsingLinkedHashMap(int cacheSize) {
        super(cacheSize, 1, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap cache = new LRUCacheUsingLinkedHashMap(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);


    }
}
