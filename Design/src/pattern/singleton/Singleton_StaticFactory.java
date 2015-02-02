package pattern.singleton;

public class Singleton_StaticFactory {
	// initailzed during class loading
	private static final Singleton_StaticFactory INSTANCE = new Singleton_StaticFactory();

	// to prevent creating another instance of Singleton
	private Singleton_StaticFactory() {
	}

	public static Singleton_StaticFactory getInstance() {
		return INSTANCE;
	}
}
