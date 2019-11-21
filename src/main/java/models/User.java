package models;

public class User {
	private String name;
	private String sex;
	private String create_date;
	private String last_login_date;
	private String age;
	
	public User(String name,String sex,String create_date,String login_date,String age) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.sex = sex;
		this.create_date = create_date;
		this.last_login_date = login_date;
		this.name = name;
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
}
