package core;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import core.client.net.Client;
import core.server.net.Server;

public class App {

	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			Server server = new Server(27027);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Client client = new Client("24.232.106.85", 27027);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*while(true){
		Socket socket = new Socket("24.232.106.85", 7777);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject("Lol");
		}*/
	}
}
