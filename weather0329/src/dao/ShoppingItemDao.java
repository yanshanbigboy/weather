package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ShoppingItem;
import connection.DBConnection;

public class ShoppingItemDao {
	/**
	 * 在购物车表中获取最大
	 * 
	 * @param item
	 * @return
	 */
	public static int addItem(ShoppingItem item) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "insert into shoppingitem (num,elem,area,frequency,name,company,phoneNUm,email,addRequest) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getMaxId());
			pstmt.setString(2, item.getElem());
			pstmt.setString(3, item.getArea());
			pstmt.setString(4, item.getFrenquency());
			pstmt.setString(5, item.getName());
			pstmt.setString(6, item.getCompany());
			pstmt.setString(7, item.getPhoneNum());
			pstmt.setString(8, item.getEmail());
			pstmt.setString(9, item.getAddRequest());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	/**
	 * 获取购物车最大ID,在最大ID基础上+1
	 * 
	 * @return
	 */
	public static int getMaxId() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int maxId = 0;
		try {
			conn = DBConnection.getConn();
			sql = "select max(num) from shoppingitem";
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
}
