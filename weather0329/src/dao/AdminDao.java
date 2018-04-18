package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import connection.DBConnection;

public class AdminDao {
	public static int addAdmin(Admin admin) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "insert into admin (adminname,adminpassword) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminName());
			pstmt.setString(2, admin.getAdminPassword());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static String adminLogin(Admin admin) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		String adminPasswordDB = null;
		try {
			conn = DBConnection.getConn();
			sql = "select adminpassword from admin where adminname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminPasswordDB = rs.getString("adminpassword");
			}else{
				adminPasswordDB="nothing";
			}
			System.out.println("this is AdminDao adminLogin " + adminPasswordDB);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}

		return adminPasswordDB;
	}

	public static int updateAdminPassword(Admin admin, String password) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "update user set adminpassword=? where adminname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, admin.getAdminName());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static int delAdmin(Admin admin) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "delete from user where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminName());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static List printAllAdmins() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Admin> adminsList = new ArrayList<Admin>();
		String sql = "";
		try {
			conn = DBConnection.getConn();
			sql = "select * from admin";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Admin admins = new Admin(rs.getString("adminname"),
						rs.getString("adminpassword"));
				adminsList.add(admins);
			}// rs.get~()，括号里表示的是列名

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return adminsList;
	}

	public static List queryAdmin(String adminName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		List<Admin> adminsList = new ArrayList<Admin>();
		try {
			conn = DBConnection.getConn();
			sql = "select* from admin where adminname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Admin admins = new Admin(rs.getString("adminname"),
						rs.getString("adminpassword"));
				adminsList.add(admins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return adminsList;

	}
}
