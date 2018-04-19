package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.DBUtil;
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
			pstmt.setInt(1, DBUtil.getNextId("shoppingitem", "num"));
			pstmt.setString(2, item.getElem());
			pstmt.setString(3, item.getArea());
			pstmt.setString(4, item.getFrequency());
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

}
