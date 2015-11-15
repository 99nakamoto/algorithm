import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		// Meeting[] m = new Meeting[4];
		// m[0] = new Meeting(1, 6);
		// m[1] = new Meeting(2, 4);
		// m[2] = new Meeting(3, 5);
		// m[3] = new Meeting(5, 7);
		// ins.minNumConf(m);
		//
		// m = new Meeting[4];
		// m[0] = new Meeting(1, 6);
		// m[1] = new Meeting(2, 4);
		// m[2] = new Meeting(3, 5);
		// m[3] = new Meeting(4, 7);
		// ins.minNumConf(m);

		List<Meeting> m = new ArrayList<Meeting>();
		m.add(new Meeting(1, 6));
		m.add(new Meeting(2, 4));
		m.add(new Meeting(3, 5));
		m.add(new Meeting(4, 7));
		ins.minNumConf(m);
		
		m = new ArrayList<Meeting>();
		m.add(new Meeting(1, 6));
		m.add(new Meeting(2, 4));
		m.add(new Meeting(3, 5));
		m.add(new Meeting(5, 7));
		ins.minNumConf(m);
		
		m = new ArrayList<Meeting>();
		m.add(new Meeting(1, 6));
		m.add(new Meeting(2, 4));
		m.add(new Meeting(3, 5));
		m.add(new Meeting(5, 7));
		m.add(new Meeting(9, 10));
		m.add(new Meeting(8, 11));
		ins.minNumConf(m);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int minNumConf(List<Meeting> list) {
		if (list == null || list.size() == 0) {
			return 0;
		}

		Collections.sort(list);

		int count = 0;
		int scheduled = 0;
		while (list.size() != 0) {
			// get end time of the first un-scheduled meeting
			int endTime = list.get(0).end;
			count++;
			for (int i = list.size() - 1; i >= 0; i--) {
				if (list.get(i).start <= endTime && endTime <= list.get(i).end) {
					list.remove(i);
				}
			}
		}

		System.out.println(count);
		System.out.println("===============");
		return count;
	}
}

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	public Meeting(int a, int b) {
		start = a;
		end = b;
	}

	@Override
	public int compareTo(Meeting o) {
		return this.end - o.end;
	}
}
