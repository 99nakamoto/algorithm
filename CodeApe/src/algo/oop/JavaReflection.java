package algo.oop;

import java.lang.reflect.Method;

import common.ListNode;

public class JavaReflection {

	public static void main(String[] args) {
		Method[] methods;

		methods = ListNode.class.getMethods();

		for (Method method : methods) {
			System.out.println(formatMethodName(method.getName() + "()")
					+ method.getDeclaringClass());
		}
	}

	private static String formatMethodName(String methodName) {
		for (int i = methodName.length(); i < 30; i++) {
			methodName += ".";
		}
		return methodName;
	}
}
