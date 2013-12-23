package core.server.net;

import java.io.IOException;
import java.net.DatagramPacket;

public class Messenger {

	public Messenger() {

	}

	public static void send(String message, User user) throws IOException {
		byte[] output = message.getBytes("UTF-8");
		DatagramPacket packet = new DatagramPacket(output, output.length, user.getAddress(), user.getPort());
		Server.socket.send(packet);
	}
}
