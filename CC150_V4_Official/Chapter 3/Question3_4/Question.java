package Question3_4;

import java.util.Stack;

public class Question {

	private static final int NUM_DISKS = 5;

	public static void main(String[] args) {
		// Set up code.
		Tower[] tower = new Tower[3];
		for (int id = 0; id < 3; id++) {
			tower[id] = new Tower(id);
		}
		for (int diskSize = NUM_DISKS - 1; diskSize >= 0; diskSize--) {
			tower[0].add(diskSize);
		}
		
		System.out.println("Correct answer: ");
		tower[0].moveDisks(NUM_DISKS, tower[2], tower[1]);
	}
}

class Tower {

	private Stack<Integer> disks;
	private int index;

	public Tower(int id) {
		disks = new Stack<Integer>();
		index = id;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Disk[" + top + "]: Rod" + index() + "-->"
				+ t.index());
	}

	public void print() {
		System.out.println("Contents of Tower " + index());
		for (int i = disks.size() - 1; i >= 0; i--) {
			System.out.println("   " + disks.get(i));
		}
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}
