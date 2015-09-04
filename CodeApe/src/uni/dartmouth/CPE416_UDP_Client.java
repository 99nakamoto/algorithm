package uni.dartmouth;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class CPE416_UDP_Client {

	public static final int Msg_Length = 100;
	public static DatagramSocket aSocket = null;
	public static int serverPort = 6789;
	public static InetAddress aHost = null;
	public static int connect_status = 0;
	public static int semantics = 0;// 0 for "At-Least-Once"; 1 for
									// "At-Most-Once"
	public static int data_lost = 0; // 0 for NO; 1 for request_lost; 2 for
										// reply_lost
	public static String ss;

	public static void main(String[] args) throws UnknownHostException, IOException,
			InterruptedException {
		// String s = "0;3;23456;li sancai;p;20";
		// String s = "1;LT2A;2";
		// String s = "2;li guifu;LT1A;4/02/03;4/03/04";
		// String s = "3;23456;li sancai;p;20";
		// String s = "4;sun lei;LT2A;200";
		// String s = "5;27816;li guifu";
		// String s = "6;34567;li guifu";
		// String s = "7;23456;li sancai;a;2";
		while (connect_status == 0) {
			start_up();
			operation(read_command());
			System.out.print("...Enter to continue...");
			(new Scanner(System.in)).nextLine();
			while (connect_status == 1) {
				print_menu();
				operation(read_command());
				System.out.print("...Enter to continue...");
				(new Scanner(System.in)).nextLine();
			}

		}

	}

	/*
	 * public static String unmarshalling(byte[] b){
	 * 
	 * String msg = new String (b); msg=msg.replaceAll( "#", ""); return msg; }
	 */
	public static String unmarshalling(byte[] input) {
		String msg = new String(input);
		msg = msg.replaceAll("#", "").trim();

		char whichDay;
		String day = "", hour, min;
		int i;
		i = msg.indexOf('/');

		while (i != -1) {

			whichDay = msg.charAt(i - 1);
			hour = msg.substring(i + 1, i + 3);
			min = msg.substring(i + 4, i + 6);

			switch (whichDay) {
			case '1':
				day = "Monday";
				break;
			case '2':
				day = "Tuesday";
				break;
			case '3':
				day = "Wednesday";
				break;
			case '4':
				day = "Thursday";
				break;
			case '5':
				day = "Friday";
				break;
			case '6':
				day = "Saturday";
				break;
			case '7':
				day = "Sunday";
				break;
			}
			msg = msg.substring(0, i - 1) + day + " " + hour + ":" + min + msg.substring(i + 6);
			i = msg.indexOf('/', i + 6);
		}

		return msg;
	}

	public static byte[] marshalling(String s) {

		for (int i = s.length() - 1; i < Msg_Length; i++) {
			s += "#";
		}

		return s.getBytes();
	}

	public static void send_to_server(String s) throws IOException, InterruptedException {
		if (data_lost != 1) {
			byte[] m = marshalling(s);
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			System.out.println("Client Send: " + unmarshalling(request.getData()));
		} else {
			System.out.println("Client Send: " + s);
			Thread.sleep(3000);
			System.out.println("Time out!");
			retransmit(s);
		}
	}

	public static void _send_to_server(String s) throws IOException, InterruptedException {// for
																							// case
																							// 1
		byte[] m = marshalling(s);
		DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
		aSocket.send(request);
	}

	public static void receive_from_server() throws IOException, InterruptedException {
		if (data_lost != 2) {
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Client Received: " + unmarshalling(reply.getData()));
		} else {
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			Thread.sleep(3000);
			System.out.println("Time out!");
			retransmit(ss);
		}

	}

	public static void _receive_from_server() throws IOException {// for case 1
		byte[] buffer = new byte[1000];
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
		aSocket.receive(reply);
		System.out.println(unmarshalling(reply.getData()));
	}

	public static void connect_server(String ip) throws UnknownHostException, IOException {
		aSocket = new DatagramSocket();
		byte[] m = marshalling("9");
		aHost = InetAddress.getByName(ip);
		DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
		aSocket.send(request);
		System.out.println("Connect to server " + ip + " port: " + serverPort + " ... ");

		byte[] buffer = new byte[1000];
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
		aSocket.receive(reply);
		connect_status = 1;
		System.out.println("Server Connected!");

	}

	public static void disconnect_server() {
		aSocket.close();
		connect_status = 0;
		System.out.println("Disconnect server!");
	}

	public static void start_up() throws UnknownHostException, IOException {
		System.out.print("Welcome to facility booking system!\n"
				+ "Please enter the server ip to connect!(e.g. \"172.22.229.158\")\n" + "->");
		Scanner input = new Scanner(System.in);
		String ip = input.next();
		connect_server(ip);
		print_menu();
	}

	public static void print_menu() {
		System.out.print("####################################\n"
				+ "############### MENU ###############\n"
				+ "####################################\n"
				+ "0.Show all facilities\n"
				+ "1.Query availability of a facility\n"
				+ // no data lost test on method 1
				"2.Make a new booking\n" + "3.Shift your booking by minutes\n"
				+ "4.Monitor registry\n" + "5.Delete your booking\n" + "6.Check your booking\n"
				+ "7.Shift your booking by days\n" + "8.Configuration of semantics\n"
				+ "9.Simulate Data Lost\n" + "e.Disconnect and quit\n" + data_lost_status() + "\n"
				+ "Please enter a char from 0-9 or 'e'\n" + "->");
	}

	public static void print_simulate_lost_menu() {
		System.out.print("####################################\n"
				+ "############ Data Lost #############\n"
				+ "####################################\n" + "0.No Lost\n"
				+ "1.Client Request Lost\n" + "2.Server Reply Lost\n" + "->");
	}

	public static String read_command() {
		String command = (new Scanner(System.in)).next();
		if (command.length() != 1) {
			System.out.print("Please enter a char from 0-9 or e \n" + "->");
			return read_command();
		} else if (command.equalsIgnoreCase("e")) {
			return command;
		} else if (command.compareTo("0") >= 0 && command.compareTo("9") <= 0) {
			return command;
		} else {
			System.out.print("Please enter a char from 0-9 or e \n" + "->");
			return read_command();
		}
	}

	public static void operation(String command) throws IOException, InterruptedException {
		if (command.equalsIgnoreCase("e")) {
			disconnect_server();
			System.exit(0);
		} else if (command.equals("9")) {
			print_simulate_lost_menu();
			simulate_lost();
		} else if (command.equals("8")) {
			configuration_semantics();
		} else {
			switch (Integer.parseInt(command)) {
			case 0:// show_all_facility
				show_all_facility();
				break;
			case 1:// show availability
				show_availability();
				break;
			case 2:// new booking
				new_booking();
				break;
			case 3:// shift by min
				shift_by_min();
				break;
			case 4:// Monitor registry
				monitor_registry();
				break;
			case 5:// delete booking
				delete_booking();
				break;
			case 6:// check booking
				check_booking();
				break;
			case 7:// shift by day
				shift_by_day();
				break;
			}
		}
	}

	public static void show_all_facility() {
		System.out.print("Available facilites:\nLT1A, LT2A, LT1-20;\n"
				+ "TR1-20, Xbox_1-20,Meeting_Room_1-20\n");
	}

	public static void show_availability() throws IOException, InterruptedException {
		ss = "";
		int num_days = 0;
		System.out.print("Please enter the facility name:->");
		String facility = (new Scanner(System.in)).next();
		System.out
				.print("Please enter the days (1-7 as Mon-Sun, seperate by \";\", e.g. 2;3;4):->");
		String days = (new Scanner(System.in)).next();
		num_days = (days.length() + 1) / 2;
		String[] str = new String[num_days];
		for (int i = 0, j = 0; i < num_days; i++, j = j + 2)
			str[i] = days.substring(j, j + 1);
		String client_send = "1;" + facility + ";" + days;
		System.out.print("Client send: " + client_send + "\n" + "Client Received:\n");
		for (int i = 0; i < num_days; i++) {
			ss = "1;" + facility + ";" + str[i];
			_send_to_server(ss);
			_receive_from_server();
		}

	}

	public static void new_booking() throws IOException, InterruptedException {
		ss = "";
		int bad_input = 0;
		System.out.print("Please enter your user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		System.out.print("Please enter the facility name:->");
		String facility = (new Scanner(System.in)).next();
		do {
			System.out.print("Please enter the start time (day/hr/min; e.g. 1/02/03):->");
			String start = (new Scanner(System.in)).next();
			System.out.print("Please enter the end time (day/hr/min; e.g. 1/02/03):->");
			String end = (new Scanner(System.in)).next();
			if (start.length() != 7 || end.length() != 7) {
				System.out.println("Booking date's format: \"x/xx/xx\"!");
				bad_input = 1;
			} else if (!start.substring(0, 1).equals(end.substring(0, 1))) {
				System.out.println("Booking should remain in the same day!");
				bad_input = 1;
			} else if (start.substring(1).compareTo(end.substring(1)) >= 0) {
				System.out.println("Booking start should be earlier then end!");
				bad_input = 1;
			} else {
				bad_input = 0;
			}
			ss = "2;" + user_name + ";" + facility + ";" + start + ";" + end + ";";
		} while (bad_input == 1);
		send_to_server(ss);
		receive_from_server();

	}

	public static void shift_by_min() throws IOException, InterruptedException {
		ss = "";
		System.out.print("Please enter your booking id:->)");
		String booking_id = (new Scanner(System.in)).next();
		System.out.print("Please enter the user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		System.out.print("Please enter the shift type (a for advance; p for postpone):->");
		String shift_type = (new Scanner(System.in)).next();
		System.out.print("Please enter the offset(mins):->");
		String offset = (new Scanner(System.in)).next();
		ss = "3;" + booking_id + ";" + user_name + ";" + shift_type + ";" + offset + ";";
		send_to_server(ss);
		receive_from_server();
	}

	public static void monitor_registry() throws IOException, InterruptedException {
		ss = "";
		System.out.print("Please enter the user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		System.out.print("Please enter the facility name:->");
		String facility = (new Scanner(System.in)).next();
		System.out.print("Please enter the length of monitor(mins):->");
		String length = (new Scanner(System.in)).next();
		ss = "4;" + user_name + ";" + facility + ";" + length;
		send_to_server(ss);
		receive_from_server();
		long End_time = System.currentTimeMillis() + Integer.parseInt(length) * 60 * 1000;
		System.out.print("Monitoring " + facility + "...\n");
		while (System.currentTimeMillis() < End_time) {
			System.out.print("->");
			receive_from_server();
		}
		System.out.println("Quit Monitoring!");
	}

	public static void delete_booking() throws IOException, InterruptedException {
		ss = "";
		System.out.print("Please enter your booking id:->");
		String booking_id = (new Scanner(System.in)).next();
		System.out.print("Please enter the user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		ss = "5;" + booking_id + ";" + user_name;
		send_to_server(ss);
		receive_from_server();
	}

	public static void check_booking() throws IOException, InterruptedException {
		ss = "";
		System.out.print("Please enter your booking id:->");
		String booking_id = (new Scanner(System.in)).next();
		System.out.print("Please enter the user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		ss = "6;" + booking_id + ";" + user_name;
		send_to_server(ss);
		receive_from_server();
	}

	public static void shift_by_day() throws IOException, InterruptedException {
		ss = "";
		System.out.print("Please enter your booking id:->");
		String booking_id = (new Scanner(System.in)).next();
		System.out.print("Please enter the user name:->");
		String user_name = (new Scanner(System.in)).nextLine();
		System.out.print("Please enter the shift type (a for advance; p for postpone):->");
		String shift_type = (new Scanner(System.in)).next();
		System.out.print("Please enter the offset(days):->");
		String offset = (new Scanner(System.in)).next();
		ss = "7;" + booking_id + ";" + user_name + ";" + shift_type + ";" + offset + ";";
		send_to_server(ss);
		receive_from_server();
	}

	public static void configuration_semantics() {
		System.out.print("Current semantics: "
				+ (semantics == 0 ? "At-Least-Once" : "At-Most-Once") + "\n"
				+ "Do you wish to change to " + (semantics == 1 ? "At-Least-Once" : "At-Most-Once")
				+ "? Y/N ->");
		if ((new Scanner(System.in)).next().equalsIgnoreCase("Y"))
			semantics = 1 - semantics;
		System.out.print("Current semantics: "
				+ (semantics == 0 ? "At-Least-Once" : "At-Most-Once") + "\n");
	}

	public static void simulate_lost() {
		String command = (new Scanner(System.in).next());
		data_lost = Integer.parseInt(command);
		print_data_lost_status();
	}

	public static void print_data_lost_status() {
		switch (data_lost) {
		case 0:
			System.out.println("Data Lost Simulation: NO");
			break;
		case 1:
			System.out.println("Data Lost Simulation: Client Request Lost");
			break;
		case 2:
			System.out.println("Data Lost Simulation: Server Reply Lost");
			break;
		}
	}

	public static String data_lost_status() {
		switch (data_lost) {
		case 0:
			return "Data Lost Simulation: NO";
		case 1:
			return "Data Lost Simulation: Client Request Lost";
		case 2:
			return "Data Lost Simulation: Server Reply Lost";
		}
		return null;
	}

	public static void retransmit(String s) throws IOException, InterruptedException {
		if (semantics == 1) {
			s = "0;" + s;
			data_lost = 0;
			System.out.println("Data Lost Mode Closed. Processing Retransmit...");
			send_to_server(s);
			receive_from_server();
		} else {
			data_lost = 0;
			System.out.println("Data Lost Mode Closed. Processing Retransmit...");
			send_to_server(s);
			receive_from_server();
		}

	}
}
