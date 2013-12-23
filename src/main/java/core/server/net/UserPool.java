package core.server.net;

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
		for (int i = 0; i < users.size(); i++) {
			InetAddress userAddress = users.get(i).getAddress();
			int userPort = users.get(i).getPort();
			if (address.equals(userAddress) && port == userPort) {
				return users.get(i);
			}
		}
		User user = new User(address, port, users.size());
		users.add(user);
		System.out.println("User added (" + address + ":" + user.getPort() + ")");
		return user;
	}
}
