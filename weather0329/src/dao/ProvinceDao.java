package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Province;
import connection.DBConnection;

public class ProvinceDao {

	public static List printProvince() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Province> provincesList = new ArrayList<Province>();
		String sql = "";
		try {
			conn = DBConnection.getConn();
			sql = "select * from province";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Province province = new Province(rs.getString("province"),
						rs.getInt("population"));
				provincesList.add(province);
			}// rs.get~()，括号里表示的是列名

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return provincesList;
	}

	public static int addProvince(Province province) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "insert into province (province,population) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, province.getProvinceName());
			pstmt.setInt(2, province.getPopulation());
			System.out.println("this is WeatherDao PrintProvinceWeat " + sql);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}

		return count;
	}

	public static int delProvince(String provinceName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			sql = "delete from province where province=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, provinceName);
			System.out.println("this is WeatherDao delProvinces " + sql);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}

		return count;
	}
}
