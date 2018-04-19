package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import connection.DBConnection;

public class UserDao {
	public static int addUser(User user){
    	PreparedStatement pstmt=null;
    	Connection conn=null;
    	String sql="";
    	int count=0;
    	try{
    		conn=DBConnection.getConn();
    		sql="insert into user (username,userpassword) values(?,?)";
    		pstmt=conn.prepareStatement(sql);
    		pstmt.setString(1, user.getUserName());
    		pstmt.setString(2,user.getUserPassword());
    		count = pstmt.executeUpdate();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DBConnection.close(pstmt, conn);
    	}
    	
    	return count;
    }
	
	public static String userLogin(User user){
		PreparedStatement pstmt=null;
    	Connection conn=null;
    	String sql="";
    	ResultSet rs=null;
    	String userPasswordDB = null;
    	try{
    		conn=DBConnection.getConn();
    		System.out.println("This is UserDAO ConnectionDB"+conn);
    		sql="select userpassword from user where username=?";
    		pstmt=conn.prepareStatement(sql);
    		pstmt.setString(1, user.getUserName());
            rs=pstmt.executeQuery();
            if (rs.next()) {
				userPasswordDB=rs.getString("userpassword");
			}else{
				userPasswordDB="nothing";
			}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DBConnection.close(pstmt, conn);
    	}
    	
    	return userPasswordDB;
    }
	
    public static int updateUserPassword(User user,String password){
	    PreparedStatement pstmt=null;
	    Connection conn=null;
	    String sql="";
	    int count=0;
	    try{
		    conn=DBConnection.getConn();
		    sql="update user set userpassword=? where username=?";
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,password);
		    pstmt.setString(2, user.getUserName());
		    count=pstmt.executeUpdate();
	    }catch(SQLException e){
		    e.printStackTrace();
	    }finally{
		    DBConnection.close(pstmt, conn);
	    }
	    return count;
    }
    
    public static int updateUserPassword(String username,String password){
	    PreparedStatement pstmt=null;
	    Connection conn=null;
	    String sql="";
	    int count=0;
	    try{
		    conn=DBConnection.getConn();
		    sql="update user set userpassword=? where username=?";
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,password);
		    pstmt.setString(2, username);
		    count=pstmt.executeUpdate();
	    }catch(SQLException e){
		    e.printStackTrace();
	    }finally{
		    DBConnection.close(pstmt, conn);
	    }
	    return count;
    }
    
    public static int delUser(String username){
	    PreparedStatement pstmt=null;
	    Connection conn=null;
	    String sql="";
	    int count=0;
	    try{
		    conn=DBConnection.getConn();
		    sql="delete from user where username=?";
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,username);
		    count=pstmt.executeUpdate();
	    }catch(SQLException e){
		    e.printStackTrace();
	    }finally{
		    DBConnection.close(pstmt, conn);
	    }
	    return count;
    }
    
    public static List printAllUsers(){
	    PreparedStatement pstmt=null;
	    Connection conn=null;
	    ResultSet rs = null;
	    List<User> usersList = new ArrayList<User>();
	    String sql="";
	    try{
		    conn=DBConnection.getConn();
		    sql="select * from user";
		    pstmt=conn.prepareStatement(sql);
		    rs=pstmt.executeQuery();
		    while(rs.next()){
			    User users = new User(rs.getString("username"),rs.getString("userpassword"));
			    usersList.add(users);
		    }//rs.get~()，括号里表示的是列名
		
	    }catch(SQLException e){
		    e.printStackTrace();
	    }finally{
		    DBConnection.close(pstmt, conn);
	    }
	    return usersList;
    }

    public static List queryUser(String userName){
	    PreparedStatement pstmt=null;
	    Connection conn=null;
	    String sql="";
	    ResultSet rs=null;
	    List<User> usersList = new ArrayList<User>();
	    try{
		    conn=DBConnection.getConn();
		    sql="select* from user where username=?";
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,userName);
		    rs=pstmt.executeQuery();	
		    while(rs.next()){
			    User users = new User(rs.getString("username"),rs.getString("userpassword"));
			    usersList.add(users);
		    }
	    }catch(SQLException e){
		    e.printStackTrace();
	    }finally{
		    DBConnection.close(pstmt, conn);
	    }
	    return usersList;
	
    }
}
