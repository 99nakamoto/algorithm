package Question9_10;

import java.util.ArrayList;

public class MyAnswer {

	public static ArrayList<Box> createStack(Box[] boxes) {
		ArrayList<Box> ans = new ArrayList<Box>();
		int len = boxes.length;
		int[] heights = new int[len];
		int[] preMap = new int[len];
		int maxIndex = 0;

		// start DP
		for (int i = 0; i < len; i++) {
			heights[i] = boxes[i].height;
			preMap[i] = -1;
			for (int j = 0; j < i; j++) {
				if (boxes[j].canBeAbove(boxes[i])) {
					int newHeight = heights[j] + boxes[i].height;
					if (newHeight > heights[i]) {
						heights[i] = newHeight;
						preMap[i] = j;
					}
				}
			}
			// now updated maxIndex
			if (heights[i] > heights[maxIndex]) {
				maxIndex = i;
			}
		}

		// print from maxIndex all the way backwards
		while (maxIndex != -1) {
			ans.add(boxes[maxIndex]);
			// the print order is reversed, so...
			maxIndex = preMap[maxIndex];
		}
		return ans;
	}

}
