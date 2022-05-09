package msiq;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Integer> cache;
	int capacity;

	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.get(key) == null)
			return -1;
		int val = cache.get(key);
		cache.remove(key);
		cache.put(key, val);

		return cache.get(key);
	}

	public void put(int key, int value) {
		if (get(key) == -1) {
			if (cache.size() == capacity) {
				int firstKey = cache.entrySet().iterator().next().getKey();
				cache.remove(firstKey);
			}
		}
		cache.put(key, value);
	}
}
