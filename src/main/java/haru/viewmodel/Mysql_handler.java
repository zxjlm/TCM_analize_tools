package haru.viewmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.bcel.generic.D2F;

import haru.models.User;
import haru.view.MainFrame;

//重要：sql连接的具体阐释，见sql_query_name()函数

public class Mysql_handler {

	public static ResultSet sql_query(String sql) {
		/*
		 * sql查询，查询的结果会以ResultSet结构返回，可能会出现bug，已经弃用
		 * 这里保留是用作反面教材，与sql_query_name和login_validate对照
		 */
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/javaproject?useSSL=false", "root",
					"root");

			PreparedStatement ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
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
		/*
		 * sql执行，传入的sql为标准的sql语句 返回布尔值，表示操作成功或者失败
		 * 
		 * 注意：查询语句与操作语句分用两个函数，因为查询返回的是结果，操作返回的是操作是否完成，注意两者的区别。
		 */

		Connection con = null;
		Boolean rs = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://39.108.229.166:3306/javaproject?useSSL=false&useUnicode=true&characterEncoding=utf-8",
					"root", "root");
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
			if (con != null) {
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
		/*
		 * 查询sql的login_name属性的所有值，用来形成一个name_list,用来比对注册请求中是否会出现重复的用户名
		 * 
		 * 注意：这里当然可以通过给login_name赋unique属性，来使得login_name唯一，不过这样错误发生在远程数据库，
		 * 并且增加了本地程序和远程数据库的交互次数，所以选择获取login_name列表，在本地进行约束
		 * 当然你还可以为login_name建立一个全局变量，这样可以进一步地减少交互
		 */
		Connection con = null;
		ResultSet rs = null;
		List<String> name_l = new ArrayList<String>();
		try {
			// MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/javaproject?useSSL=false", "root",
					"root");

			// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/javaproject?useSSL=false","root","root");

			PreparedStatement ps = con.prepareStatement("select login_name from user");
			// 预编译sql语句

			rs = ps.executeQuery();
			// 执行sql语句，将查询的结果存放在rs中
			// 每次连接数据库，都要记得关闭连接；而在连接关闭之后，rs的生命周期结束，所以试图返回rs是不可能的
			// 于是我使用了一个list，来存放查询的结果，list的生命周期是可以由我自己决定的

			while (rs.next()) {
				String name_tmp = rs.getString("login_name");
				name_l.add(name_tmp);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					// 关闭与数据库的连接
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return name_l;
	}

	public static Boolean login_validate(String name, String pwd) {
		/*
		 * 用来验证登录操作是否能够成功 传入login_name和password两个属性，用来查询验证 返回是否允许登录
		 */
		Connection con = null;
		ResultSet rs = null;
		Boolean res = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/javaproject?useSSL=false", "root",
					"root");

			PreparedStatement ps = con.prepareStatement("select * from user");

			rs = ps.executeQuery();

			while (rs.next()) {
				Date date = new Date();
				String name_tmp = rs.getString("login_name");
				String pwd_tmp = rs.getString("password");
				if (name_tmp.equals(name) && pwd_tmp.equals(pwd)) {
					res = true;
					MainFrame.usr = new User(rs.getString("name"), rs.getString("sex"), rs.getString("create_date"),
							String.format("%tF%n", date) + " " + String.format("%tT%n", date), rs.getString("age"),
							rs.getString("email"), rs.getString("login_name"), rs.getString("age"), "unshown");
					MainFrame.usr.update_logindate();
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
			if (con != null) {
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
