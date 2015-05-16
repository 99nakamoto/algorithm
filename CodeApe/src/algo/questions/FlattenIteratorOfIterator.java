package algo.questions;

import java.util.List;

public class FlattenIteratorOfIterator {

	public static void main(String[] args) {
		FlattenIteratorOfIterator ins = new FlattenIteratorOfIterator();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	class IteratorIterator {

		List list;
		int p = 0;

		public IteratorIterator(List list) {
			this.list = list;
		}

		public boolean hasNext() {
			return true;
		}

		public int getNext() {
			if (p == list.size()) {
				return -1;
			} else if (list.get(p) == null) {
				p++;
				return getNext();
			}
			if (list.get(p) instanceof Integer) {
				p++;
				return (int) list.get(p);
			} else {
				IteratorIterator it = new IteratorIterator((List) list.get(p));
				 if (it.hasNext()) {
					 // TODO
				 }
			}

			return -999;
		}
	}
}
