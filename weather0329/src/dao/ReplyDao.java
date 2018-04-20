package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.DBUtil;
import bean.Reply;
import connection.DBConnection;

public class ReplyDao {

	public static int addReply(int sendId, Reply reply) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "insert into reply(reply_id,send_id,reply_name,reply_content) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, DBUtil.getNextId("reply", "reply_id"));
			pstmt.setInt(2, sendId);
			pstmt.setString(3, reply.getReplyName());
			pstmt.setString(4, reply.getReplyContent());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}
}
