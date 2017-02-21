package Question8_4;

import java.util.ArrayList;

public class MyAnswer {

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> ans = new ArrayList<String>();
		if (s.length() == 1) {
			ans.add(s);
			return ans;
		}
		char single = s.charAt(0);
		ArrayList<String> partialPerms = getPerms(s.substring(1));
		for (String part : partialPerms) {
			for (int i = 0; i <= part.length(); i++) {
				ans.add(part.substring(0, i) + single + part.substring(i));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abcde");
		System.out.println("My answer");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
