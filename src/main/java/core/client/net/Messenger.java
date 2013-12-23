package core.client.net;

import java.io.IOException;
import java.net.DatagramPacket;

public class Messenger {

	public Messenger() {

	}

	public static void send(String message) throws IOException {
		byte[] output = message.getBytes("UTF-8");
		DatagramPacket packet = new DatagramPacket(output, output.length, Client.host, Client.port);
		Client.socket.send(packet);
	}

}
