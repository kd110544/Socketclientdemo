
public class CMessage {

	private String from;
	private String to;
	private String message;
	private boolean read;

	public CMessage(String from, String to, String message, boolean read) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
		this.read = read;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	

}
