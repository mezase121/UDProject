package core.net.data;

import java.net.InetAddress;

public interface PlainMessage {

	public InetAddress getAddress();

	public int getPort();

	public String getMessage();
	
	public String toString();
}
