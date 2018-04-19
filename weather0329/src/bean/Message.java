package bean;

import java.util.List;

public class Message {
	private int sendId;
	private String sendName;
	private String sendContent;
	private List<Reply> replyList;

	public String getAllReply() {
		for (Reply reply : replyList) {
			return reply.getReplyName() + ":" + reply.getReplyContent() + ";";
		}
		return "";
	}

	public Message() {

	}

	public Message(int sendId, String sendName, String sendContent) {
		super();
		this.sendId = sendId;
		this.sendName = sendName;
		this.sendContent = sendContent;
	}

	public Message(int sendId, String sendName, String sendContent,
			List<Reply> replyList) {
		super();
		this.sendId = sendId;
		this.sendName = sendName;
		this.sendContent = sendContent;
		this.replyList = replyList;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
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
