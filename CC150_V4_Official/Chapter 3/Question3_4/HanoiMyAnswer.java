package Question3_4;

import java.util.Stack;

public class HanoiMyAnswer {

	static Rod r0, r1, r2;

	public static void main(String[] args) {
		r0 = new Rod(0, 3);
		r1 = new Rod(1);
		r2 = new Rod(2);
		moveDisks(3, r0, r2, r1);
	}

	private static void moveDisks(int number, Rod from, Rod to, Rod buffer) {
		int temp;
		if (number == 1) {
			temp = from.disks.pop();
			to.disks.push(temp);
			print(temp, from.name, to.name);
		} else {
			moveDisks(number - 1, from, buffer, to);
			temp = from.disks.pop();
			to.disks.push(temp);
			print(temp, from.name, to.name);
			moveDisks(number - 1, buffer, to, from);
		}
	}

	private static void print(int disk, int from, int to) {
		System.out.println("Disk[" + disk + "]: Rod" + from + "-->" + to);
	}
}

class Rod {

	int name;
	Stack<Integer> disks;

	public Rod(int name) {
		this.name = name;
		disks = new Stack<Integer>();
	}

	public Rod(int name, int n) {
		this(name);
		for (int i = n - 1; i >= 0; i--) {
			disks.push(i);
		}
	}
}