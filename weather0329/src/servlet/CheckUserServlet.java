package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import connection.DBConnection;



public class CheckUserServlet extends HttpServlet {
	private static InitialContext initContext=null;
	private DataSource dataSource=null;
	Context envContext=null;
	Connection conn=null;
    String sql="";
	/**
	 * Constructor of the object.
	 */
	public CheckUserServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   conn=DBConnection.getConn();
           String username="";
           username=request.getParameter("username");
           System.out.println("username===="+username);
           String sql="select * from user where username='"+username+"'";
           System.out.println("sql==="+sql);
           response.setContentType("text/html;charset=utf-8");
           PrintWriter pw=response.getWriter();
           try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()){
				pw.write("true");
			}else {
				pw.write("false");
				System.out.println("false");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public void init() throws ServletException{
		 try {
			initContext = new InitialContext();
			envContext=(Context)initContext.lookup("java:/comp/env");
			dataSource=(DataSource)envContext.lookup("jdbc/mysql");
			conn=dataSource.getConnection();
		} catch (NamingException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}catch(SQLException e2){
			e2.printStackTrace();
		}
	}

}
