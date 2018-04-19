package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Message;


<<<<<<< HEAD
import connection.DBConnection;

public class MessageDao {
	
    public static List printMessage(){
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	String sql="";
    	List<Message> messageList =new ArrayList<Message>();
    	ResultSet rs=null;
    	try {
			conn=DBConnection.getConn();
			sql="select * from message";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Message msg=new Message(rs.getString("name"),rs.getString("content"));
				messageList.add(msg);
=======
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
				if (pre == rs.getInt("send_id") && messageList.size() != 0) {// 说明是之前一个结果的send_id与现在send_id相同
					// 说明是针对同一个留言的回复
					// 获取messageList中Message对象包涵的replyList对象
					List<Reply> replyList = ((Message) (messageList
							.get(messageList.size() - 1))).getReplyList();
					if (messageList.size() == 0) { // 说明肯定没有replyList对象
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
				} else {// 前一个结果的send_id与现在的send_id不同，说明不是针对同一个留言的回复
					Message msg = new Message(rs.getInt("send_id"),
							rs.getString("send_name"),
							rs.getString("send_content"));
					messageList.add(msg);
					pre = rs.getInt("send_id");
				}
>>>>>>> origin/bowen4
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt, conn);
		}
    	return messageList;
    }
    
    public static int addMessage(Message msg){
    	PreparedStatement pstmt=null;
    	Connection conn=null;
    	String sql="";
    	int count=0;
    	try {
			conn=DBConnection.getConn();
			sql="insert into message(name,content,telephone,email) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, msg.getName());
			pstmt.setString(2, msg.getContent());
			pstmt.setString(3, msg.getTelephone());
			pstmt.setString(4, msg.getEmail());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt, conn);
		}
    	return count;
    }
    public static int delMessage(String name){
    	PreparedStatement pstmt=null;
    	Connection conn=null;
    	String sql="";
    	int count=0;
    	try {
			conn=DBConnection.getConn();
			sql="delete * from message where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(pstmt, conn);
		}
    	return count;
    }
    public static String printone(String name){
    	PreparedStatement pstmt=null;
    	Connection conn=null;
    	String sql="";
    	ResultSet rs=null;
    	String cont=null;
    	try {
			conn=DBConnection.getConn();
			sql="select content from message where name=?";
			pstmt.setString(1, name);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				cont=rs.getString("content");
				System.out.println("测试"+cont);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		   e.printStackTrace();
		}finally{
			DBConnection.close(pstmt, conn);
		}
    	return cont;
    }
}
