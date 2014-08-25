package algo.lowlevel;

/*
 * I refered to Java source code to implementing this HashMap
 */

public class HashMapImpl {

	Pair[] table;
	float loadFactor;
	int size;

	public HashMapImpl(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0 || loadFactor <= 0) {
			return;
		}
		table = new Pair[initialCapacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public String get(int key) {
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		Pair e = table[i];
		for (; e != null; e = e.next) {
			if (e.hash == hash && key == e.key) {
				return e.value;
			}
		}
		return null;
	}

	public String put(int key, String value) {
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		Pair e = table[i];
		for (; e != null; e = e.next) {
			if (e.hash == hash && key == e.key) {
				String oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		addEntry(hash, key, value, i);
		return null;
	}

	void addEntry(int hash, int key, String value, int i) {
		// in charge of resizing here (check the load factor)
		// resizing code is not written here
		Pair e = table[i];
		table[i] = new Pair(hash, key, value, e);
	}

	int indexFor(int h, int length) {
		return h & (length - 1);
	}

	final int hash(int code) {
		// this is the hash function from java 6 source code
		code ^= (code >>> 20) ^ (code >>> 12);
		return code ^ (code >>> 7) ^ (code >>> 4);
	}

	public static void main(String[] args) {
		HashMapImpl map = new HashMapImpl(16, 0.5f);
		map.put(1, "aaa");
		map.put(2, "bbbb");
		map.put(3, "ccccc");
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		map.put(1, "aaa second time");
		map.put(3, "ccc second time");
		map.put(4, "dddddd");
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		System.out.println(map.get(4));
		System.out.println(map.get(5));
	}

	class Pair {
		int hash;
		int key;
		String value;
		Pair next;

		Pair(int h, int k, String v, Pair n) {
			hash = h;
			key = k;
			value = v;
			next = n;
		}
	}
}