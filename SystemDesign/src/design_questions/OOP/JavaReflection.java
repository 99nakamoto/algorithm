package design_questions.OOP;

import java.lang.reflect.Method;

import map_reduce.simple.MyMapReduce;

public class JavaReflection {

	public static void main(String[] args) {
		Method[] methods;

		methods = MyMapReduce.class.getMethods();

		for (Method method : methods) {
			System.out.println(formatMethodName(method.getName() + "()")
					+ method.getDeclaringClass());
		}
	}

	private static String formatMethodName(String methodName) {
		for (int i = methodName.length(); i < 50; i++) {
			methodName += ".";
		}
		return methodName;
	}
}
