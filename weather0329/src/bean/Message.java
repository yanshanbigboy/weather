package bean;

public class Message {
	private String sendName;
	private String sendContent;

	public Message() {

	}

	public Message(String sendName, String sendContent) {
		super();
		this.sendName = sendName;
		this.sendContent = sendContent;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

}
