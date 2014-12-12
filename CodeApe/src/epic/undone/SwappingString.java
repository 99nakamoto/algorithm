package epic.undone;

public class SwappingString {

	public static void main(String[] args) {
		SwappingString ins = new SwappingString();
		ins.otherPplSolution();

		System.out.println();
	}

	private void solution() {

	}

	void otherPplSolution() {
		char[] a = "ACADBB123".toCharArray();
		char[] b = "DC1BA32BA".toCharArray();
		char temp;
		int n = b.length;
		int j, i = 0;
		while (n > i) {
			j = i;
			System.out.println(a);
			while (a[j] != b[i]) {
				j++;
			}
			while (j > i) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				System.out.println(a);
				j--;
			}
			i++;
		}
	}
}
