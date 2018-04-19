package dao;

public class ReplyDao {
	String replyName;
	String replyContent;

	public ReplyDao() {
		super();
	}

	public ReplyDao(String replyName, String replyContent) {
		super();
		this.replyName = replyName;
		this.replyContent = replyContent;
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
