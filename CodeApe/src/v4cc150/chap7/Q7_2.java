package v4cc150.chap7;

import java.util.List;

public class Q7_2 {

	// Imagine you have a call center with three levels of employees

	public static class CallHandler {

		private static final CallHandler instance = new CallHandler();

		static final int LEVEL = 3;
		List<List<Employee>> employeeLevels;
		List<List<Call>> callQueues;

		private CallHandler() {
		}

		public static CallHandler getInstance() {
			return instance;
		}

		public Employee getHandler(Call c) {
			return c.handler;
		}

		void dispatchCall(Call c) {
			Employee emp = getHandler(c);
			if (emp != null) {
				emp.receive(c);
				c.handler = emp;
			} else {
				c.reply("Please wait a moment");
				callQueues.get(c.rank).add(c);
			}
		}
	}

	public class Call {
		int rank = 0;
		Employee handler;

		public void reply(String msg) {
		}

		public void disconnect() {
		}

		public void setHandler(Employee e) {
			handler = e;
		}
	}

	abstract class Employee {
		int rank;
		Call currentCall = null;

		public Employee(int val) {
			rank = val;
		}

		void receive(Call c) {

		}

		void handle(Call c) {

		}

		void escalete(Call c) {
			c.rank = c.rank + 1;
		}
	}

	class Director extends Employee {
		public Director(int val) {
			super(2);
		}

	}

	class Manager extends Employee {
		public Manager(int val) {
			super(1);
		}

	}

	class Respondent extends Employee {

		public Respondent(int val) {
			super(0);
		}

	}
}