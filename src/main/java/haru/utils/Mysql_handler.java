package haru.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql_handler {
	
	public static ResultSet sql_opt(String sql) {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TCM_DICT?useSSL=false","root","root");

//			String sql = "select * from user where status = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "1");
			
			
			rs = ps.executeQuery();
			
//			while(rs.next()) {
//				String name = rs.getString("s_name");
//				String id = rs.getString("bin_hid");
//				System.out.println("name:"+name+" id:"+id);
//			}
			
			
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
		return rs;
	}
	
}
