package haru.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import haru.utils.Mysql_handler;

public class User {
	private String name;
	private String sex;
	private String create_date;
	private String last_login_date;
	private String age;
	private String email;
	private String login_name;
	private String tel;
	private String password;
	
	public User(String name,String sex,String create_date,String login_date,String age,String email,String login_name,String tel,String password) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.sex = sex;
		this.create_date = create_date;
		this.last_login_date = login_date;
		this.name = name;
		this.email = email;
		this.login_name = login_name;
		this.tel = tel;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getCreate_date() {
		return create_date;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getLast_login_date() {
		return last_login_date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public Boolean signin() {
		List<String> rs = Mysql_handler.sql_query_name();
		
		if(rs.indexOf(name) != -1) {
			return false;
		}
		
		String sql = String.format("INSERT INTO user(`name`,`password`,`status`,`login_name`,`email`,`last_login_date`,`create_date`,`sex`,`age`,`tel`) "
				+ "VALUES ('%s','%s','1','%s','%s','%s','%s','%s','%s','%s')", name,password,login_name,email,last_login_date,create_date,sex,age,tel);
		Boolean res = Mysql_handler.sql_execute(sql);
		
		return res;
	}
	
	public Boolean update_logindate() {
		Date date = new Date();
		String sql = "update user set last_login_date='"+String.format("%tF%n", date)+" "+String.format("%tT%n",date)+"' where login_name='"+login_name+"'";
		return Mysql_handler.sql_execute(sql);
	}
	
}
