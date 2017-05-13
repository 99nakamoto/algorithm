package algo.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumBusStations {

	public static void main(String[] args) {
		NumBusStations ins = new NumBusStations();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		List<Meeting> input = new ArrayList<Meeting>();

		input.add(new Meeting(1, 3));
		input.add(new Meeting(4, 7));
		input.add(new Meeting(2, 6));
		input.add(new Meeting(6, 10));
		
		System.out.println("solve1 = " + ins.solve1(input));
		System.out.println("solve2 = " + ins.solve2(input));
		System.out.println("==============================");

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int solve1(List<Meeting> input) {
		// linear solution: sort list of events by mixing start and end time
		List<Event> events = new ArrayList<Event>();
		for (Meeting i : input) {
			events.add(new Event(i.start, 1));
			events.add(new Event(i.end, -1));
		}
		Collections.sort(events);

		for (Event e : events) {
			System.out.print("(" + e.time + ",  " + e.diff + ") ");
		}
		System.out.println();

		int currentNeeds = 0;
		int maxNeeds = 0;
		for (Event e : events) {
			currentNeeds += e.diff;
			maxNeeds = Math.max(maxNeeds, currentNeeds);
		}
		return maxNeeds;
	}
	
	public int solve2(List<Meeting> input) {
		// heap solution: sort by end time, and count # of start times
		// TODO
		return 1;
	}
}

class Event implements Comparable<Event> {
	int time;
	int diff;
	// variable diff have value of 1 or -1
	// when = 1, it means starting a meeting and 1 more room needed
	// when = -1, it means ending a meeting and 1 less room needed

	public Event(int a, int b) {
		time = a;
		diff = b;
	}

	@Override
	public int compareTo(Event o) {
		if (this.time == o.time) {
			return this.diff - o.diff;
		}
		return this.time - o.time;
	}
}

class Meeting {
	int start;
	int end;

	public Meeting(int a, int b) {
		start = a;
		end = b;
	}
}