package uni.dartmouth;
//package cpe416_udp_server;

import java.net.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPE416_UDP_Server {

	public static final int Msg_Length = 1000;
	public static String filePath = "/Users/shanpaocungu/NetBeansProjects/xml/booking.xml";
	public static int call_back = 0;
	public static String monitor_facility = "";
	public static String monitor_reply = "";
	public static String current_client_port = "";
	public static String current_client_ip = "";
	public static String last_msg = "";
	public static String last_re_msg = "";
	public static DatagramSocket aSocket = null;

	public static void main(String[] args) throws UnknownHostException {

		// initialy display host IP address in the console
		System.out.println(InetAddress.getLocalHost());

		try {
			aSocket = new DatagramSocket(6789);
			while (true) {
				byte[] buffer = new byte[Msg_Length];
				// 1. get request
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				System.out.println("Server Received: " + unmarshalling(request.getData()));

				// 2. unmarshalling (with check)
				String msg = "";
				// System.out.println("request.getData() = "+request.getData());
				if (fault_check(request.getData()))
					msg = unmarshalling(request.getData());
				else
					System.out.println("Request is corrupted, try again later.");
				// request re-transmit

				// System.out.println("Finish Unmarshalling, msg = "+ msg);
				current_client_port = Integer.toString(request.getPort());// for
																			// case
																			// 4
				current_client_ip = request.getAddress().toString().substring(1);
				// System.out.println("current_client_ip = "+
				// current_client_ip);

				// check if it's re-transmitted

				// 3. Operations on Msg
				byte[] result = marshalling(operation(msg));

				// 4. Rely to Client (Confirmation)
				// result -> byte stream
				DatagramPacket reply = new DatagramPacket(result, result.length,
						request.getAddress(), request.getPort());
				aSocket.send(reply);
				System.out.println("Server Replied: \n" + unmarshalling(reply.getData()));
				// call back, facility_name
				if (call_back == 1) {
					System.out.println("Procesing Call Back...");
					call_back(monitor_facility, monitor_reply);
					System.out.println("Call Back Finished!");
				}
				// record history
			}
		} catch (SocketException ex) {
			Logger.getLogger(CPE416_UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(CPE416_UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
		}

		finally {
			if (aSocket != null) {
				aSocket.close();
			}
		}
	}

	public static boolean fault_check(byte[] b) {

		if (b.length == Msg_Length)
			return true;
		else
			return false;

	} // Check whether it is a valid message

	public static String unmarshalling(byte[] b) {

		String msg = new String(b);
		msg = msg.replaceAll("#", "");
		return msg.trim();
	} //

	public static String operation(String msg) throws IOException {
		return "";
	}

	public static byte[] marshalling(String s) {
		for (int i = s.length() - 1; i < Msg_Length; i++) {
			s += "#";
		}
		return s.getBytes();
	}

	public static enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public static Day return_day(int i) {
		switch (i) {
		case 1:
			return Day.MONDAY;
		case 2:
			return Day.TUESDAY;
		case 3:
			return Day.WEDNESDAY;
		case 4:
			return Day.THURSDAY;
		case 5:
			return Day.FRIDAY;
		case 6:
			return Day.SATURDAY;
		case 7:
			return Day.SUNDAY;
		}
		return null;
	}

	public static boolean check_facility(String facility) {
		return false;
	}

	public static String show_availability(String facility, String date) {
		return "";
	}

	public static boolean check_id(String booking_id) throws IOException {

		return true;
	}

	public static boolean check_time(String facility, String start, String end) throws IOException {

		return true;
	}

	public static boolean check_time(String booking_id, String facility, String start, String end)
			throws IOException {

		return true;
	}

	public static void insert_record(String[] str, String booking_id) {
	}

	public static void call_back(String facility, String monitor_reply) throws IOException {

	}

	public static String delete_booking(String booking_id, String user_name) throws IOException {
		return "";
	}

	public static String show_booking_info(String[] str) throws IOException {
		return "";
	}

	public static String change_booking_day(String[] str) throws IOException {
		return "";
	}
}
