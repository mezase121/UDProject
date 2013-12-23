package core.client.net;

import java.io.IOException;
import java.net.DatagramPacket;

public class Listener implements Runnable {

	private byte[] input;
	private String received;

	public Listener() {
	}

	public void run() {
		while (true) {
			//if (received == null) { //make null once processed
				try {
					input = new byte[256];
					DatagramPacket packet = new DatagramPacket(input, input.length);
					Client.socket.receive(packet);

					received = new String(packet.getData(), 0, packet.getLength());
					System.out.println("Client received: " + received);
				} catch (IOException e) {
					e.printStackTrace();
				}
			//}
		}
	}

}
