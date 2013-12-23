package core.net.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static InetAddress host;
	public static int port;
	public static DatagramSocket socket;
	private boolean running = true;
	
	private MessageQueue messages = new MessageQueue();

	public Client(String host, int port) throws IOException {
		this.host = InetAddress.getByName(host);
		this.port = port;
		socket = new DatagramSocket();

		int inc = 0;
		String message = "Client";

		new Thread(new Listener(messages)).start();
		
		while(true){
			Messenger.send("Hola");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
