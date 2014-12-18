package dartmouth;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPE425_UDP_Client {

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

	private InetAddress aHost;
	private int serverPort;

	private String newline = "\n";
	byte[] buffer;

// server-side code
public void setupServer() throws UnknownHostException {

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

			// 2. unmarshalling (with fault check)
			String msg = "";
			if (fault_check(request.getData())) {
				msg = unmarshalling(request.getData());
			} else {
				// request re-transmit
				System.out.println("Request is corrupted, please try again later.");
			}

			current_client_port = Integer.toString(request.getPort());
			current_client_ip = request.getAddress().toString().substring(1);

			// 3. Operations on Msg
			byte[] result = marshalling(operation(msg));

			// 4. Rely to Client (confirmation)
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

// client-side code
public String connectToServer(String address, int portNumber) {

	// connectToServer() is used to setting up and update connection
	// information (like port number, server address etc. in case of change)
	try {
		System.out.println(InetAddress.getLocalHost().toString());
	} catch (UnknownHostException ex) {
	}

	if (aSocket != null) {
		return new String("Connection already exist, please do not reconnect." + newline);
	}

	try {
		aSocket = new DatagramSocket();
		aHost = InetAddress.getByName(address);
		serverPort = portNumber;
	} catch (UnknownHostException ex) {
		Logger.getLogger(CPE425_UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SocketException ex) {
		Logger.getLogger(CPE425_UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
	}

	return (sendToServer("9;Hello server!"));
}

	private void call_back(String monitor_facility2, String monitor_reply2) {
		// TODO Auto-generated method stub

	}

	private Object operation(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean fault_check(byte[] b) {
		return true;
	}

	private byte[] marshalling(Object object) {
		return null;
	}

	private String unmarshalling(byte[] input) {
		return null;
	}

	public String sendToServer(String sendMessage) {

		String returnMessage = "";
		System.err.println(sendMessage);

		try {

			byte[] m = sendMessage.getBytes();
			// aHost = InetAddress.getByName(args[1]);
			// aHost = InetAddress.getByName("Code-Monkeys-MacBook-Pro.local");
			// aHost = InetAddress.getLocalHost();

			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			returnMessage += new String("Client Send: " + new String(request.getData(), "US-ASCII")
					+ newline);

			buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			String receivedMessage = unmarshalling(reply.getData());
			returnMessage += new String("Client Receive: " + receivedMessage + newline);
			// new String(reply.getData(), "US-ASCII")

		} catch (UnknownHostException ex) {
			Logger.getLogger(CPE425_UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(CPE425_UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return returnMessage;
	}
}
