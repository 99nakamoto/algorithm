import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class FlatIterator implements Iterator {
	List<Object> list;
	Stack<Iterator> stack;
	Iterator currIterator;

	public FlatIterator(List<Object> list) {
		this.list = list;
		stack = new Stack<Iterator>();
		currIterator = list.iterator();
	}

	public boolean hasNext() {

		if (!currIterator.hasNext()) {
			if (stack.isEmpty())
				return false;
			else {
				return stack.peek().hasNext();
			}
		} else {
			return true;
		}
	}

	public Integer next() {
		if (currIterator.hasNext()) {

			Object curr = currIterator.next();
			if (curr instanceof Integer)
				return (Integer) curr;
			else {
				stack.push(currIterator);
				currIterator = ((List<Object>) curr).iterator();
				return this.next();
			}
		} else if (!stack.isEmpty()) {
			currIterator = stack.pop();
			return this.next();
		}
		return null;
	}

}