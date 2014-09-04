package algo.lowlevel;

import java.util.LinkedList;

/*
 * This implementation simply use (string.length() % array_size) 
 * as hash function
 *  
 */

public class HashMapCC150<K, V> {

	private static final int SIZE = 10;
	LinkedList<Cell<K, V>>[] items;

	public HashMapCC150() {
		items = (LinkedList<Cell<K, V>>[]) new LinkedList[SIZE];
	}

	public V get(K k) {
		int hashValue = this.calculateHashCode(k);
		if (items[hashValue] == null) {
			items[hashValue] = new LinkedList<Cell<K, V>>();
			return null;
		}
		for (Cell<K, V> cell : items[hashValue]) {
			if (k.equals(cell.getKey())) {
				return cell.getValue();
			}
		}
		return null;
	}

	public V put(K k, V v) {
		int hashValue = this.calculateHashCode(k);
		if (items[hashValue] == null) {
			items[hashValue] = new LinkedList<Cell<K, V>>();
		}
		for (Cell<K, V> cell : items[hashValue]) {
			if (k.equals(cell.getKey())) {
				items[hashValue].remove(cell);
				break;
			}
		}
		Cell<K, V> newItem = new Cell<K, V>(k, v);
		items[hashValue].add(newItem);
		return null;
	}

	public V remove(K k) {
		// not written
		return null;
	}

	private int calculateHashCode(K k) {
		return k.toString().length() % SIZE;
	}

	public static void main(String[] args) {
		HashMapCC150<String, String> map = new HashMapCC150<String, String>();
		map.put("kevin", "durant");
		map.put("steven", "curry");
		map.put("al", "jefferson");
		System.out.println(map.get("kevin"));
		System.out.println(map.get("steven"));
		System.out.println(map.get("al"));
		map.put("kevin", "martin");
		map.put("steven", "nash");
		map.put("kevin", "braynt");
		System.out.println(map.get("kevin"));
		System.out.println(map.get("steven"));
		System.out.println(map.get("al"));
	}
}

class Cell<K, V> {

	private K key;
	private V value;

	public Cell(K k, V v) {
		key = k;
		value = v;
	}

	public boolean equivalent(Cell<K, V> c) {
		return equivalent(c.getKey());
	}

	public boolean equivalent(K k) {
		return key.equals(k);
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
