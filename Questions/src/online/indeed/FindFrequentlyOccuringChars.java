package online.indeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindFrequentlyOccuringChars {

	public static void main(String[] args) {
		FindFrequentlyOccuringChars ins = new FindFrequentlyOccuringChars();
		String str = null;

		str = "dbecedccddeebdae";
		System.out.println("Input is " + str);
		System.out.println("Output is: ");
		ins.printRes(str);
		System.out.println();

		str = "z";
		System.out.println("Input is " + str);
		System.out.println("Output is: ");
		ins.printRes(str);
		System.out.println();

		str = "ajklfajdlkfajsdklfjalljaklsdfjaklsdjf";
		System.out.println("Input is " + str);
		System.out.println("Output is: ");
		ins.printRes(str);
		System.out.println();
	}

	public void printRes(String str) {
		// count occurrence in a array map
		int[] occ = new int['z' - 'a' + 1];
		for (char ch : str.toCharArray()) {
			occ[ch - 'a']++;
		}

		// build a list of CharOccur
		List<CharOccur> list = new ArrayList<CharOccur>();
		for (int i = 0; i < occ.length; i++) {
			if (occ[i] == 0)
				continue;
			list.add(new CharOccur((char) (i + 'a'), occ[i]));
		}

		// sort the list of CharOccur
		Collections.sort(list, new Comparator<CharOccur>() {

			@Override
			public int compare(CharOccur arg0, CharOccur arg1) {
				if (arg0.occurrence != arg1.occurrence) {
					return arg1.occurrence - arg0.occurrence;
				} else {
					return arg0.character - arg1.character;
				}
			}
		});

		// output result
		for (CharOccur co : list) {
			System.out.println(co.character);
		}
	}

	class CharOccur {
		char character;
		int occurrence;

		public CharOccur(char a, int b) {
			this.character = a;
			this.occurrence = b;
		}
	}
}
