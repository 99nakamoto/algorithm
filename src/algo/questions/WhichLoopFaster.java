package algo.questions;

public class WhichLoopFaster {

	public static void main(String args[]) {
		solution();
	}

	public static void solution() {
		int i, j, k, l;
		k = 0;
		l = 0;
		/* FIRST */
		for (i = 0, l++; i < 10; i++, k++)
			for (j = 0, l++; j < 100; j++, k++)
				;
		// printf("First Loop: %d\t%d\n", k, l);
		System.out.println(k);
		System.out.println(l);

		k = 0;
		l = 0;
		/* SECOND */
		for (i = 0, l++; i < 100; i++, k++)
			for (j = 0, l++; j < 10; j++, k++)
				;
		// printf("Second Loop: %d\t%d\n", k, l);
		System.out.println(k);
		System.out.println(l);
	}
}
