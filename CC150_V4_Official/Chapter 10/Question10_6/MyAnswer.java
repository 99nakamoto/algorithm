package Question10_6;

import java.util.HashMap;

/*
 * My answer written here is WRONG!
 * I gave up. 
 * 
 */

public class MyAnswer {

	public static MyLine getCollinear(GraphPoint[] points) {
		int maxCollinear = 1;
		MyLine ans = null;
		// for every ponit, build a hashmap and check same line
		for (GraphPoint curPt : points) {
			HashMap<MyLine, Integer> map = new HashMap<MyLine, Integer>();
			for (GraphPoint aPt : points) {
				if (aPt.x < curPt.x) {
					// ignore half of the cases
					continue;
				} else if (aPt.x - curPt.x < MyLine.epsilon
						&& aPt.y - curPt.y < MyLine.epsilon) {
					continue;
				}
				// now draw a line between curPt and aPt
				MyLine aLine = null;
				if (aPt.x - curPt.x < MyLine.epsilon) {
					aLine = new MyLine(Double.NaN, aPt.x);
				} else {
					double slope = (aPt.y - curPt.y) / (aPt.x - curPt.x);
					double intercept = aPt.y - (slope * aPt.x);
					aLine = new MyLine(slope, intercept);
				}
				if (!map.containsKey(aLine)) {
					map.put(aLine, 1);
				}
				int collinear = map.get(aLine) + 1;
				map.put(aLine, collinear);
				// check max collinear
				if (collinear > maxCollinear) {
					maxCollinear = collinear;
					ans = aLine;
					System.out.println("ans updated, count is " + maxCollinear);
				}
			}
		}
		return ans;
	}
}

class MyLine {

	public static double epsilon = .0001;

	public double slope = 0;
	public double intercept = 0;

	public MyLine(double a, double b) {
		slope = a;
		intercept = b;
	}

	public void Print() {
		System.out.println("slope = " + slope + "\nintercept = " + intercept);
	}

	@Override
	public int hashCode() {
		int a = (int) (slope * 1000);
		int b = (int) (intercept * 1000);
		if (slope == Double.NaN) {
			return b;
		} else {
			return a + b;
		}
	}

	@Override
	public boolean equals(Object o) {
		MyLine other = (MyLine) o;
		return this.slope - other.slope < epsilon
				&& this.intercept - other.intercept < epsilon;
	}
}
