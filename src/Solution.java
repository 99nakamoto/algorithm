import algo.singleton.Singleton_DoubleCheckedLocking;
import algo.singleton.Singleton_Enum;
import algo.singleton.Singleton_StaticFactory;

public class Solution {
	public static void main(String[] args) {

	}

	public void something() {
		Singleton_DoubleCheckedLocking a = Singleton_DoubleCheckedLocking
				.getInstance();

		Singleton_Enum b = Singleton_Enum.INSTANCE;

		Singleton_StaticFactory c = Singleton_StaticFactory.getInstance();
	}
}