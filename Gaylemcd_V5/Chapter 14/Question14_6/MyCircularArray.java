package Question14_6;

import java.util.Iterator;

public class MyCircularArray<T> implements Iterable<T> {

	T[] items;

	int head;
	int cur;

	public MyCircularArray(int size) {
		// this is really important (casting the type)
		items = (T[]) new Object[size];

		head = 0;
		cur = 0;
	}

	public void put(T item) {
		items[cur++] = item;
		cur = cur % items.length;
	}

	public T get(int i) {
		int newIndex = (i + head) % items.length;
		return items[newIndex];
	}

	public void rotate(int shiftRight) {
		head += shiftRight;
		head = head % items.length;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}

	class MyIterator<T> implements Iterator<T> {

		T[] items;
		int head;
		int count;

		public MyIterator(MyCircularArray<T> array) {
			this.items = array.items;
			this.head = array.head;
			this.count = 0;
		}

		@Override
		public boolean hasNext() {
			return this.count != items.length;
		}

		@Override
		public T next() {
			if (hasNext()) {
				return items[(head + count++) % items.length];
			}
			return null;
		}

		@Override
		public void remove() {
		}
	}

}
