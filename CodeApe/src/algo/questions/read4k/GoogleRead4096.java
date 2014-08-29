package algo.questions.read4k;

public class GoogleRead4096 {

	// Given API: int Read4096(char* buf);
	// It reads data from a file and records the position so that the next time
	// when it is called it read the next 4k chars (or the rest of the file,
	// whichever is smaller) from the file. The return is the number of chars
	// read.
	// Use above API to Implement API "int Read(char* buf, int n)" which reads
	// any number of chars from the file.

	String buffer = null;
	int p = 0;

	public String read(int n) {
		if (n < 0) {
			return null;
		} else if (n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			// there is (LENGTH - p) chars left in the local buffer
			if (buffer == null || p == buffer.length()) {
				// no char left in buffer, update buffer
				buffer = GoogleApi.read4096();
				p = 0;
				if (buffer.length() == 0) {
					// finish reading the file (no more input chars)
					break;
				}
			} else {
				int numChars = buffer.length() - p;
				if (numChars >= n) {
					sb.append(buffer.substring(p, p + n));
					p = p + n;
					n = 0;
				} else {
					sb.append(buffer.substring(p));
					p = buffer.length();
					n -= numChars;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		GoogleRead4096 ins = new GoogleRead4096();

		// first, test GoogleApi.read4096()
		System.out.println("Input file: ");
		for (int i = 0; i < 9; i++) {
			System.out.print(GoogleApi.read4096() + ", ");
		}
		System.out.println(GoogleApi.read4096());

		// now, test read() method
		System.out.println();
		System.out.println("Output string: ");
		GoogleApi.begin();
		System.out.println(ins.read(3) + " 3");
		System.out.println(ins.read(3) + " 3");
		System.out.println(ins.read(3) + " 3");
		System.out.println(ins.read(3) + " 3");
		System.out.println(ins.read(12) + " 12");
		System.out.println(ins.read(6) + " 6");
		System.out.println(ins.read(6) + " 6");
		System.out.println(ins.read(20) + " 20");
		System.out.println(ins.read(100) + " 100");
	}

}
