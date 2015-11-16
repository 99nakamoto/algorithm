public class regex {

	public static void main(String[] args) {
		String ss = "ajk	f:j-d.d;s,al asdf sda ff";
		System.out.println(ss);
		System.out.println();

		String[] ar = ss.split("[\\s\\t\\.,-:;]");
		for (String s : ar) {
			System.out.println(s + "");
		}
	}
}
