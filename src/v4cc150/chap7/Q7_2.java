package v4cc150.chap7;

public class Q7_2 {

	// Imagine you have a call center with three levels of employees

	public static class CallHandler {
		private static final CallHandler instance = new CallHandler();

		private CallHandler() {
		}

		public static CallHandler getInstance() {
			return instance;
		}
		
		void dispatchCall(Call call) {
			
		}
		
		void getNextCall(Employee )
	}

	public class Call {
		int rank = 0;

		public void reply(String msg) {
		}

		public void disconnect() {
		}
	}

	abstract class Employee {
		CallHandler callHandler;
		int rank;
		boolean free;

		public Employee(int val) {
			rank = val;
		}

		void receive(Call c) {

		}

		void handle(Call c) {

		}

		void escalete(Call c) {
			c.rank = c.rank + 1;
			callHandler.dispatchCall(c);
			free = true;
			callHandler.getNextCall(this);
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