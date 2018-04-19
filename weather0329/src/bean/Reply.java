package bean;

public class Reply {
	private int replyId;
	private String replyName;
	private String replyContent;

	public Reply() {
		super();
	}

	public Reply(int replyId, String replyName, String replyContent) {
		super();
		this.replyId = replyId;
		this.replyName = replyName;
		this.replyContent = replyContent;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
