import java.util.HashMap;
import java.util.Scanner;

public class MagicBox {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input");
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();

		char[][] matrix = new char[m][n];
		for (int i = 0; i < m; i++) {
			matrix[i] = sc.nextLine().toCharArray();
		}

		// print, comment out before release
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.print(matrix[x][y]);
			}
			System.out.println();
		}

		int res = magicbox(matrix);
		System.out.println(res);
		sc.close();
	}

	private static int magicbox(char[][] matrix) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// build the hash map, count similar patterns
		for (char[] line : matrix) {
			String str = stringify(line);
			String reverse = reversedStringify(line);
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else if (map.containsKey(reverse)) {
				map.put(reverse, map.get(reverse) + 1);
			} else {
				map.put(str, 1);
			}
		}

		// extract the largest number from hashmap
		int largest = 1;
		for (int i : map.values()) {
			largest = Math.max(largest, i);
		}
		return largest;
	}

	private static String stringify(char[] line) {
		String res = "";
		for (char c : line) {
			res += c;
		}
		return res;
	}

	private static String reversedStringify(char[] line) {
		String res = "";
		for (char c : line) {
			res += (c == 'P' ? 'T' : 'P');
		}
		return res;
	}
}
