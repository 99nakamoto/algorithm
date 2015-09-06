package multi_threading.lock_reentry;

public class Testing {
	public static void main(String args[]) {

		MyInt myInt = new MyInt(0);

        System.out.println("The result: num1 should be less than 200, cuz 2 thread race");
        System.out.println("            the other 2 variables are synced.");
        System.out.println("            0ne using our LockReentrant. One using Java built-in LockReentrant.");
        System.out.println("The result: ");

        IncrementThread thread1 = new IncrementThread(myInt);
        IncrementThread thread2 = new IncrementThread(myInt);
        IncrementThread thread3 = new IncrementThread(myInt);
        IncrementThread thread4 = new IncrementThread(myInt);

		new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
        new Thread(thread4).start();

	}
}
