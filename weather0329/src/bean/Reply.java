package bean;

public class Reply {
	private String sendName;
	private String replyName;
	private String replyContent;

	public Reply() {
		super();
	}

	public Reply(String sendName, String replyName, String replyContent) {
		super();
		this.sendName = sendName;
		this.replyName = replyName;
		this.replyContent = replyContent;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}
