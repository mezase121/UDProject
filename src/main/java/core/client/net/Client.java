package core.client.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static InetAddress host;
	public static int port;
	public static DatagramSocket socket;
	private boolean running = true;

	public Client(String host, int port) throws IOException {
		this.host = InetAddress.getByName(host);
		this.port = port;
		socket = new DatagramSocket();

		int inc = 0;
		String message = "Client";

		new Thread(new Listener()).start();

		while (running) {
			Messenger.send(message+inc);
			inc++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
