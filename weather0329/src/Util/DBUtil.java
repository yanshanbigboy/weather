package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import connection.DBConnection;

public class DBUtil {

	/**
	 * ��ȡ���е����ID,�����ID������+1
	 * 
	 * @return
	 */
	public static int getNextId(String dbName, String columName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int maxId = 0;
		try {
			conn = DBConnection.getConn();
			sql = "select max(" + columName + ") from " + dbName;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return maxId + 1;
	}

	@Test
	public void test() {
		String dbName = "message";
		String columName = "send_id";
		int i = getNextId(dbName, columName);
		System.out.println("i===" + i);
	}

	/**
	 * ��ȡ���е���СID
	 * 
	 * @return
	 */
	public static int getMinId(String dbName, String columName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int minId = 0;
		try {
			conn = DBConnection.getConn();
			sql = "select min(" + columName + ") from " + dbName;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				minId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return minId;
	}
}
