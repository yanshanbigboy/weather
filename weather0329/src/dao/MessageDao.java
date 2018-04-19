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
				System.out.println("id===" + rs.getInt("send_id"));
				if (pre == rs.getInt("send_id") && messageList.size() != 0) {// ˵����֮ǰһ�������send_id������send_id��ͬ
					// ˵�������ͬһ�����ԵĻظ�
					// ��ȡmessageList��Message���������replyList����111
					List<Reply> replyList = ((Message) (messageList
							.get(messageList.size() - 1))).getReplyList();
					if (messageList.size() == 0) { // ˵���϶�û��replyList����
						replyList = new ArrayList<Reply>();
						Reply reply = new Reply(rs.getInt("reply_id"),
								rs.getString("reply_name"),
								rs.getString("reply_content"));
						replyList.add(reply);
						Message message = (Message) (messageList
								.get(messageList.size() - 1));
						message.setReplyList(replyList);
						messageList.add(message);
						pre = rs.getInt("send_id");
					} else {
						Reply reply = new Reply(rs.getInt("reply_id"),
								rs.getString("reply_name"),
								rs.getString("reply_content"));
						replyList.add(reply);
						pre = rs.getInt("send_id");
					}
				} else {// ǰһ�������send_id�����ڵ�send_id��ͬ��˵���������ͬһ�����ԵĻظ�
					Message msg = new Message(rs.getInt("send_id"),
							rs.getString("send_name"),
							rs.getString("send_content"));
					messageList.add(msg);
					pre = rs.getInt("send_id");
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
				System.out.println("����" + cont);
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
