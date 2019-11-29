package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Mysql_demo {
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//			Class.forName("com.mysql.jdbc.Driver");  
			
			
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TCM_DICT?useSSL=false","root","root");

			String sql = "select * from test where status = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "1");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("test2");
				String id = rs.getString("test1");
				System.out.println("name:"+name+" id:"+id);
			}
			System.out.println("over");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
