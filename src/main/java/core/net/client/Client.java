package core.net.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

import core.net.data.MessageQueue;

public class Client {

	public static InetAddress host;
	public static int port;
	public static DatagramSocket socket;
	
	private MessageQueue messages = new MessageQueue();

	public Client(String host, int port) throws IOException {
		this.host = InetAddress.getByName(host);
		this.port = port;
		socket = new DatagramSocket();

		Thread listenerThread = new Thread(new Listener(messages));
		listenerThread.setDaemon(true);
		listenerThread.start();
		
		Thread messageHandlerThread = new Thread(new MessageHandler(messages));
		messageHandlerThread.setDaemon(true);
		messageHandlerThread.start();
		
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
