package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.file;

import connection.DBConnection;

public class FileDao {
	public static int addFileINFO(file file){
		Connection conn=null;     /*真实文件名（带前缀）                           原始文件名                                   文件描述                            文件真实路径*/
    	PreparedStatement pstmt=null;
    	String sql="";
    	int count=0;
    	try{
    		conn=DBConnection.getConn();
    		sql="insert into file(realFileName,fileName,fileMess,fileURL) values (?,?,?,?)";
    		pstmt=conn.prepareStatement(sql);
    		pstmt.setString(1,file.getRealFileName());
    		pstmt.setString(2,file.getFileName());
    		pstmt.setString(3,file.getFileMess());
    		pstmt.setString(4,file.getFileURL());
    		count=pstmt.executeUpdate();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DBConnection.close(pstmt, conn);
    	}
		return count;
	}
	
	public  static List<file> queryMSG(){
		Connection conn=null;
    	PreparedStatement pstmt=null;
    	String sql="";
    	ResultSet rs=null;
    	List<file> fileList=new ArrayList<file>();
    	try{
    		conn=DBConnection.getConn();
    		sql="select * from file";
    		pstmt=conn.prepareStatement(sql);
		    rs=pstmt.executeQuery();
		    while(rs.next()){
		    	file files=new file(rs.getString("realFileName"),rs.getString("fileName")
		    			,rs.getString("fileMess"),rs.getString("fileURL"));
		    	fileList.add(files);
		    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		DBConnection.close(pstmt, conn);
    	}
		return fileList;
	}
	
	public static String queryRealURL(String RealFileName){
		Connection conn=null;
    	PreparedStatement pstmt=null;
    	String sql="";
    	String realFileURL=null;
    	ResultSet rs=null;
    	System.out.println("dao file realfilename="+RealFileName);
    	try{
    		conn=DBConnection.getConn();
    		Statement stmt = conn.createStatement();
    		sql="select fileURL from file where realFileName='" + RealFileName+"'";
    		System.out.println("dao file queryRealURL sql="+ sql);
    		/*stmt=conn.prepareStatement(sql);*/
            rs=stmt.executeQuery(sql);
            if (rs.next()) {
				realFileURL=rs.getString("fileURL");
			}else{
				realFileURL="nothing";
			}
            System.out.println("dao file realfileurl="+realFileURL);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		DBConnection.close(pstmt, conn);
    	}
		return realFileURL;
		
	}
	

}
