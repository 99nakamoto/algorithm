package algo.singleton;

import algo.singleton.Singleton_DoubleCheckedLocking;
import algo.singleton.Singleton_Enum;
import algo.singleton.Singleton_StaticFactory;

public class SingleInstantiationTesting {
	public static void main(String[] args) {

	}

	public void something() {
		// use double checked lock
		Singleton_DoubleCheckedLocking a = Singleton_DoubleCheckedLocking
				.getInstance();

		// use enum
		Singleton_Enum b = Singleton_Enum.INSTANCE;

		// use static factory
		Singleton_StaticFactory c = Singleton_StaticFactory.getInstance();
	}
}