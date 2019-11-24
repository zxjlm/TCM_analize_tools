package haru.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import haru.models.User;
import haru.view.MainFrame;

public class Mysql_handler {
	
	public static ResultSet sql_query(String sql) {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");

			PreparedStatement ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			

			
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
	
	
	public static Boolean sql_execute(String sql) {
		// TODO Auto-generated method stub
		Connection con = null;
		Boolean rs = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TCM_DICT?useSSL=false","root","root");

			PreparedStatement ps = con.prepareStatement(sql);
			
//			System.out.println(sql);
			rs = ps.execute();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	
	public static List<String> sql_query_name() {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		List<String> name_l = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");

			PreparedStatement ps = con.prepareStatement("select login_name from user");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String name_tmp = rs.getString("login_name");
				name_l.add(name_tmp);
			}
			
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
		return name_l;
	}
	
	
	public static Boolean login_validate(String name,String pwd) {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		Boolean res = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false","root","root");

			PreparedStatement ps = con.prepareStatement("select * from user");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String name_tmp = rs.getString("login_name");
				String pwd_tmp = rs.getString("password");
				if(name_tmp.equals(name) && pwd_tmp.equals(pwd)) {
					res = true;
					MainFrame.usr.update_logindate();
					MainFrame.usr = new User(rs.getString("name"), rs.getString("sex"), rs.getString("create_date"), rs.getString("last_login_date"), rs.getString("age"), rs.getString("email"), rs.getString("login_name"), rs.getString("age"), "unshown");
					System.out.println(rs.getString("name"));
					break;
				}
			}
			
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
		return res;
	}
}
