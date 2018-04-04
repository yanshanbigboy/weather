package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Message;


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
			pstmt.setInt(3, msg.getTelephone());
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
				System.out.println("≤‚ ‘"+cont);
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
