package Question9_7;

public class Question {

	public static String PrintColor(Color c) {
		switch (c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}

	public static void PrintScreen(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void PrintScreen(Color[][] screen1, Color[][] screen2) {
		for (int i = 0; i < screen1.length; i++) {
			for (int j = 0; j < screen1[0].length; j++) {
				System.out.print(PrintColor(screen1[i][j]));
			}
			System.out.print(" ");
			for (int j = 0; j < screen2[0].length; j++) {
				System.out.print(PrintColor(screen2[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static boolean PaintFill(Color[][] screen, int x, int y,
			Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
			return false;
		}
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			PaintFill(screen, x - 1, y, ocolor, ncolor); // left
			PaintFill(screen, x + 1, y, ocolor, ncolor); // right
			PaintFill(screen, x, y - 1, ocolor, ncolor); // top
			PaintFill(screen, x, y + 1, ocolor, ncolor); // bottom
		}
		return true;
	}

	public static boolean PaintFill(Color[][] screen, int x, int y, Color ncolor) {
		if (screen[y][x] == ncolor)
			return false;
		return PaintFill(screen, x, y, screen[y][x], ncolor);
	}

	public static void main(String[] args) {
		int N = 10;
		Color[][] screen1 = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen1[i][j] = Color.Black;
			}
		}
		for (int i = 0; i < 100; i++) {
			screen1[randomInt(N)][randomInt(N)] = Color.Green;
		}
		Color[][] screen2 = new Color[N][N];
		Color[][] screen3 = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen2[i][j] = screen1[i][j];
				screen3[i][j] = screen1[i][j];
			}
		}

		System.out.println("Original input:");
		System.out.println("Fill [2,2] with color 'W'... ");
		PrintScreen(screen1);
		PaintFill(screen1, 2, 2, Color.White);

		System.out.println("Solution(left), my answer 1(right)");
		MyAnswer.PaintFill1(screen2, 2, 2, Color.White);
		PrintScreen(screen1, screen2);

		System.out.println("Solution(left), my answer 2(right)");
		MyAnswer.PaintFill2(screen3, 2, 2, Color.White);
		PrintScreen(screen1, screen3);
	}

}
