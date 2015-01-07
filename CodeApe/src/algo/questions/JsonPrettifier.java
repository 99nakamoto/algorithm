package algo.questions;

public class JsonPrettifier {

	public static void main(String[] args) {
		JsonPrettifier ins = new JsonPrettifier();
		String input = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"age\":25,\"height_cm\":167.6,\"address\":{\"streetAddress\":\"212ndStreet\",\"city\":\"NewYork\",\"state\":\"NY\",\"postalCode\":\"10021-3100\" },\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"212555-1234\"},{\" type\":\"office\",\"number\":\"646555-4567\"}],\"children\":[],\"spouse\":null}";
		System.out.println("Input: ");
		System.out.println(input);
		System.out.println();

		System.out.println("Output: ");
		try {
			ins.prettify(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void prettify(String input) throws Exception {

		// observation the rules for Json format:
		// 1. each line end with either a { , or }
		// 2. indentation depends on number of brackets
		int len = input.length();
		int left = 0;
		int right = 0;
		int tab = 0;

		while (left < len) {
			// first, advance right pointer to the next line break point
			while (right < len) {
				if (input.charAt(right) == '}' || input.charAt(right) == ']') {
					// first case, if point to a closing bracket
					tab--;
					// indentation should change right away should we find a
					// closing bracket
					if (right + 1 < len && input.charAt(right + 1) != ',') {
						break;
					}
				} else if (input.charAt(right) == ','
						|| input.charAt(right) == '{'
						|| input.charAt(right) == '[') {
					// second case, break at , or {
					break;
				} else if (right + 1 < len
						&& (input.charAt(right + 1) == '}' || input
								.charAt(right + 1) == ']')) {
					// third case, break prior to }
					// we need not swap the order of first and third case,
					// because when we found a closing bracket, we need to
					// change indentation right away
					break;
				}
				right++;
			}

			// now print the chars from left pointer to right inclusively
			if (right == len) {
				// end of input
				if (tab != 0) {
					throw new Exception("Json format error!");
				}
				right--;
				// this is for the convenience of printing last line
			}
			printIndentation(tab);
			System.out.println(input.substring(left, right + 1));
			if (input.charAt(right) == '{' || input.charAt(right) == '[') {
				tab++;
			}

			// last, update pointers
			left = ++right;
		}
	}

	private void printIndentation(int tab) {
		for (int i = 0; i < tab; i++) {
			System.out.print("    ");
		}
	}
}
