package Question14_6;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		CircularArray<String> array1 = new CircularArray<String>(size);
		MyCircularArray<String> array2 = new MyCircularArray<String>(size);
		for (int i = 0; i < size; i++) {
			array1.set(i, String.valueOf(i));
			array2.put(String.valueOf(i));
		}

		array1.rotate(3);
		array2.rotate(3);
		System.out.println("Rotate by 3: ");
		for (int i = 0; i < size; i++) {
			System.out.print(" * " + array1.get(i));
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(" * " + array2.get(i));
		}
		System.out.println();

		array1.rotate(2);
		array2.rotate(2);
		System.out.println("Rotate by another 2: ");
		for (String s : array1) {
			System.out.print(" - " + s);
		}
		System.out.println();
		for (String s : array2) {
			System.out.print(" - " + s);
		}
		System.out.println();
	}

}
