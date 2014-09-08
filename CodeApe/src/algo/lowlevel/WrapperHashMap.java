package algo.lowlevel;

import java.util.HashMap;

public class WrapperHashMap {

	public static void main(String[] args) {
		WrapperHashMap ins = new WrapperHashMap();
		ins.solution();
	}

	public void solution() {

		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
		map.put("abc", 3425);
		map.put("harry", 45);
		map.put("potter", 37);
		map.put("bcd", 898);
		map.put("ceci", 23);
		map.put("car", 4);
		map.put("harry", 46);

		System.out.println(map.get("potter"));
		System.out.println(map.get("d"));

		System.out.println(MyHashMap.getCount());
	}

	public static class MyHashMap<K, V> extends HashMap<K, V> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static int count = 0;

		public V put(K key, V value) {
			count++;
			return super.put(key, value);
		}

		public V get(Object key) {
			count++;
			return super.get(key);
		}

		public static int getCount() {
			return count;
		}
	}
}