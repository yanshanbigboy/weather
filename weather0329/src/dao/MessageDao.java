package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.DBUtil;
import bean.Message;
import bean.Reply;
import connection.DBConnection;

public class MessageDao {

	public static List printMessage() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		List<Message> messageList = new ArrayList<Message>();
		ResultSet rs = null;

		try {
			int pre = DBUtil.getMinId("message", "send_id");
			System.out.println("pre==" + pre);
			conn = DBConnection.getConn();
			sql = "select * from message,reply where message.send_id=reply.send_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("id===" + rs.getInt("send_id")
						+ "reply content==" + rs.getString("reply_content"));

				if (pre == rs.getInt("send_id") && messageList.size() != 0) {// 说明是之前一个结果的send_id与现在send_id相同
					// 说明是针对同一个留言的回复
					// 获取messageList中Message对象包涵的replyList对象111
					List<Reply> replyList = ((Message) (messageList
							.get(messageList.size() - 1))).getReplyList();
					if (replyList != null) { // 说明有replyList对象
						System.out.println("replyList != null");
						Reply reply = new Reply(rs.getInt("reply_id"),
								rs.getString("reply_name"),
								rs.getString("reply_content"));
						replyList.add(reply);
						Message message = (Message) (messageList
								.get(messageList.size() - 1));
						message.setReplyList(replyList);
						messageList.remove(messageList.size() - 1);
						messageList.add(message);
						System.out.println("replysize==" + replyList.size());
						// pre = rs.getInt("send_id");
						// System.out.println("pre==" + pre);
					} else {
						System.out.println("replyList != null  -----else");
						Reply reply = new Reply(rs.getInt("reply_id"),
								rs.getString("reply_name"),
								rs.getString("reply_content"));
						replyList.add(reply);
						// pre = rs.getInt("send_id");
						// System.out.println("pre==" + pre);
					}
				} else {
					// pre != rs.getInt("send_id") 或 messageList.size() ==0的情况
					System.out.println("else");
					List<Reply> replyList = new ArrayList<Reply>();
					Reply reply = new Reply(rs.getInt("reply_id"),
							rs.getString("reply_name"),
							rs.getString("reply_content"));
					replyList.add(reply);
					Message msg = new Message(rs.getInt("send_id"),
							rs.getString("send_name"),
							rs.getString("send_content"), replyList);
					messageList.add(msg);
					System.out.println("else----reply_content"
							+ messageList.get(0).getReplyList().get(0)
									.getReplyContent());
					// pre = rs.getInt("send_id");
					// System.out.println("pre==" + pre);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return messageList;
	}

	public static int addMessage(Message msg) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "insert into message(send_id,send_name,send_content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, DBUtil.getNextId("message", "send_id"));
			pstmt.setString(2, msg.getSendName());
			pstmt.setString(3, msg.getSendContent());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static int delMessage(String name) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "delete * from message where send_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static String printone(String name) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		String cont = null;
		try {
			conn = DBConnection.getConn();
			sql = "select content from message where send_name=?";
			pstmt.setString(1, name);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cont = rs.getString("content");
				System.out.println("测试" + cont);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return cont;
	}
}
