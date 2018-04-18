package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Util.StringUtil;
import bean.Weather;
import connection.DBConnection;

public class WeatherDao {
	public static int addProvinceWeather(Weather weather) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "insert into "
					+ weather.getProvince()
					+ " (month,province,avgPressure,avgTemperature,avgHumidity,avgPrecipitation,avgWindSpeed) values("
					+ weather.getMonth() + ",'" + weather.getProvince() + "',"
					+ weather.getAvgPressure() + ","
					+ weather.getAvgTemperature() + ","
					+ weather.getAvgHumidity() + ","
					+ weather.getAvgPrecipitation() + ","
					+ weather.getAvgWindSpeed() + ")";
			count = stmt.executeUpdate(sql);
			System.out.println("this is WeatherDao addProvinceWeather " + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}

		return count;
	}

	public static int addProvinceTable(String provinceName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "create table "
					+ provinceName
					+ " (month int primary key,province varchar(255),avgpressure float(255,1),avgtemperature float(255,1),avghumidity int,avgprecipitation float(255,1),avgwindspeed float(255,1))";
			System.out.println("this is WeatherDao addProvinceTable " + sql);
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}

		return count;
	}

	public static int delProvinceWeather(String provinceName, int month) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "delete from " + provinceName + " where month=" + month;
			System.out.println("this is WeatherDao-delProvinceWeather " + sql);
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static int delProvinceTable(String provinceName) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int count = 0;
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "drop table " + provinceName;
			System.out.println("this is WeatherDao addProvinceTable " + sql);
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return count;
	}

	public static List<Weather> priProWeaByElem(String area, String elem) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Weather> weathersList = new ArrayList<Weather>();
		String sql = "";
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "select" + elem + "from " + area;
			System.out.println("this is WeatherDao priProWeaByElem " + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Weather weathers = new Weather(rs.getInt("month"),
						rs.getString("province"), rs.getDouble("avgpressure"),
						rs.getDouble("avgtemperature"),
						rs.getInt("avghumidity"),
						rs.getDouble("avgprecipitation"),
						rs.getDouble("avgwindspeed"));
				weathersList.add(weathers);
			}// rs.get~()，括号里表示的是列名
			for (Weather weathers : weathersList) {
				System.out.println(weathers.getProvince());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return weathersList;
	}

	public static List<Weather> printProvinceWeather(Weather weather) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Weather> weathersList = new ArrayList<Weather>();
		String sql = "";
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "select * from "
					+ StringUtil.ProRevert(weather.getProvince());
			System.out
					.println("this is WeatherDao PrintProvinceWeather " + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Weather weathers = new Weather(rs.getInt("month"),
						rs.getString("province"), rs.getDouble("avgpressure"),
						rs.getDouble("avgtemperature"),
						rs.getInt("avghumidity"),
						rs.getDouble("avgprecipitation"),
						rs.getDouble("avgwindspeed"));
				weathersList.add(weathers);
			}// rs.get~()，括号里表示的是列名
			for (Weather weatherss : weathersList) {
				System.out.println(weatherss.getProvince());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return weathersList;
	}
    
	public static List<Weather> printProvinceWeatherUser(Weather weather) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Weather> weathersList = new ArrayList<Weather>();
		String sql = "";
		try {
			conn = DBConnection.getConn();
			Statement stmt = conn.createStatement();
			sql = "select * from "
					+ StringUtil.ProRevert(weather.getProvince())+" "+"where month < 7";
			System.out
					.println("this is WeatherDao PrintProvinceWeather " + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Weather weathers = new Weather(rs.getInt("month"),
						rs.getString("province"), rs.getDouble("avgpressure"),
						rs.getDouble("avgtemperature"),
						rs.getInt("avghumidity"),
						rs.getDouble("avgprecipitation"),
						rs.getDouble("avgwindspeed"));
				weathersList.add(weathers);
			}// rs.get~()，括号里表示的是列名
			for (Weather weatherss : weathersList) {
				System.out.println(weatherss.getProvince());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		return weathersList;
	}
	// 将用户指定的地区、元素进行查询并导入xls文件的sql语句
		public static void priProWeaByElem(String[] area, String elem,
				String fileAddress) {
			PreparedStatement pstmt = null;
			Connection conn = null;
			ResultSet rs = null;
			List<Weather> weathersList = new ArrayList<Weather>();
			String sql = "";
			try {
				conn = DBConnection.getConn();
				Statement stmt = conn.createStatement();
				for (int i = 0; i < area.length - 1; i++) {
					sql = sql + "select month,province," + elem + " from "
							+ area[i] + " UNION ";
				}
				sql = sql + "select month,province," + elem + " from "
						+ area[area.length - 1] + " into outfile '" + fileAddress
						+ "'";

				System.out.println("this is WeatherDao priProWeaByElem " + sql);

				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(pstmt, conn);
			}
		}

		@Test
		public void bowenTest() {
			WeatherDao dao = new WeatherDao();
			String[] area = { "beijing", "tianjin" };
			dao.priProWeaByElem(area, "avgpressure", "E://5.xls");
		}

		// 查询年平均数据avg_year
		public static void printAvgYearWeather(String elem, String area[],
				String fileAddress) {
			PreparedStatement pstmt = null;
			Connection conn = null;
			ResultSet rs = null;
			String sql = "";
			try {
				conn = DBConnection.getConn();
				Statement stmt = conn.createStatement();

				sql = "select province," + elem + " from avg_year where "
						+ StringUtil.revertProChi(area) + " into outfile '"
						+ fileAddress + "'";
				System.out.println("this is WeatherDao printAvgYearWeather " + sql);
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(pstmt, conn);
			}
		}

		@Test
		public void test() {
			String elem = "avgpressure,avgwindspeed";
			String area[] = { "beijing", "hunan", "hubei" };
			// String area[] = { "beijing" };
			String fileAddress = "E://year.xls";
			WeatherDao.printAvgYearWeather(elem, area, fileAddress);
		}
	

		

	
}
