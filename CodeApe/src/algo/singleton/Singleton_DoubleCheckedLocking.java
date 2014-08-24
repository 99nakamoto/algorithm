package algo.singleton;

public class Singleton_DoubleCheckedLocking implements Cloneable {
	private static volatile Singleton_DoubleCheckedLocking INSTANCE;

	private Singleton_DoubleCheckedLocking() {
	}

	public static Singleton_DoubleCheckedLocking getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton_DoubleCheckedLocking.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new Singleton_DoubleCheckedLocking();
				}
			}
		}
		return INSTANCE;
	}
}
