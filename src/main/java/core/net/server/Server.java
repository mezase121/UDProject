package core.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.LinkedBlockingQueue;

import core.net.data.MessageQueue;

public class Server {

	public static int port;
	public static DatagramSocket socket;
	public static boolean running = true;

	private UserPool userPool = new UserPool();
	private MessageQueue messages = new MessageQueue();

	public Server(int port) throws IOException {
		this.port = port;
		socket = new DatagramSocket(port);
		
		System.out.println("Server running on port " + port + "...");

		Thread listenerThread = new Thread(new Listener(messages));
		listenerThread.setDaemon(true);
		listenerThread.start();

		Thread messageHandlerThread = new Thread(new MessageHandler(messages, userPool));
		messageHandlerThread.setDaemon(true);
		messageHandlerThread.start();
	}

	public void run() {
		

		/*
		 * while (running) { try { byte[] input = new byte[256];
		 * 
		 * DatagramPacket packet = new DatagramPacket(input, input.length); socket.receive(packet);
		 * 
		 * String received = new String(packet.getData(), 0, packet.getLength()); System.out.print("Server received: " + received);
		 * 
		 * InetAddress userAddress = packet.getAddress(); int userPort = packet.getPort(); //might have to make sure the client uses same port as server. int userNumber = userPool.addUser(userAddress, userPort); System.out.println(" from user #" +
		 * userNumber);
		 * 
		 * String message = "You are #" + userNumber; byte[] output = message.getBytes("UTF-8");
		 * 
		 * userPool.getUser(userNumber).send(message);
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } }
		 */
	}
}
