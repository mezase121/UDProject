package core.net.data;

import java.net.InetAddress;

public interface PlainUser {
	
	public InetAddress getAddress();

	public int getPort();

	public int getId();

}
