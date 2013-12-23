package core.net.server;

import java.net.InetAddress;
import java.util.ArrayList;

public class UserPool {

	private int maxUsers = 20;
	private ArrayList<User> users = new ArrayList<User>();

	public UserPool() {

	}

	public User getUser(int userNumber) {
		return users.get(userNumber);
	}

	public User addUser(InetAddress address, int port) {
		for (User user : users) {
			InetAddress userAddress = user.getAddress();
			int userPort = user.getPort();
			if (address.equals(userAddress) && port == userPort) {
				return user;
			}
		}
		User user = new User(address, port, users.size());
		users.add(user);
		System.out.println("User added (" + address + ":" + user.getPort() + ")");
		return user;
	}
}
