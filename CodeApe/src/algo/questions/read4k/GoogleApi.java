package algo.questions.read4k;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class GoogleApi {

	private static BufferedReader in = null;

	public static void begin() {
		try {
			in = new BufferedReader(new FileReader(new File(GoogleApi.class
					.getResource("read4096.txt").toURI())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static String read4096() {
		// for simplicity of testing, this method takes in the next line only
		if (in == null)
			begin();
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (line == null) {
			return "";
		} else {
			return line;
		}
	}
}
