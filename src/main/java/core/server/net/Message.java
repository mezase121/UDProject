package core.server.net;

public class Message {
	
	private User user;
	private String message;
	
	public Message(String message, User user){
		this.message = message;
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "[msg=" + message + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}
}
