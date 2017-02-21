package multi_threading.race_condition;

public class Testing {
	public static void main(String args[]) {

		MyInt myInt = new MyInt(0);

		System.out.println("The result: num should be less than 200, cuz 2 thread race");
		System.out.println("            the other 2 variables are synced, so should be fine.");
		System.out.println("The result: ");

		IncrementThread thread1 = new IncrementThread(myInt);
		IncrementThread thread2 = new IncrementThread(myInt);
		new Thread(thread1).start();
		new Thread(thread2).start();

	}
}