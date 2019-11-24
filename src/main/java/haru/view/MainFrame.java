package haru.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import haru.models.User;
import haru.utils.*;

public class MainFrame extends JFrame{
	private JPanel jContentPane;
	private JButton sqlModuleButton;
	private JButton analizeModuleButton;
	
	public static User usr;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame window = new MainFrame();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		User usr = new User("cy", "男", "2019-11-11", "2019-11-12", "20","zxjlm233@163.com","sheep","11111111111","123");     //TODO:init   
		
		getContentPane().setLayout(null);
		setForeground(Color.BLACK);
		setTitle("中医处方基础分析系统");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,Global_bool.win_width,Global_bool.win_height);
		
		jContentPane = new JPanel();
//		jContentPane.setLayout(new BorderLayout(0,0));
		jContentPane.setLayout(null);
		setContentPane(jContentPane);
		
		
		
//		TODO:add usr info
		JLabel usr_welcome = new JLabel("welcome "+usr.getName());
		usr_welcome.setBounds(513,31,139,20);
		jContentPane.add(usr_welcome);
		
		JLabel copyright = new JLabel("© 2019 Copyright  harumonia");
//		copyright.setBounds(global_bool.win_width /2 - 100,global_bool.win_height - 10,200,20);
		copyright.setBounds(Global_bool.win_width /2 - 100,Global_bool.win_height - 50,200,20);
		jContentPane.add(copyright);
		
		JPanel panel = new JPanel();
		panel.setBounds(288, 82, 364, 225);
		jContentPane.add(panel);
		panel.setLayout(null);
		
		JLabel usr_name = new JLabel("姓名:");
		usr_name.setBounds(54, 27, 30, 16);
		panel.add(usr_name);
		
		JLabel usr_name_text = new JLabel(usr.getName());
		usr_name_text.setBounds(170, 27, 73, 16);
		panel.add(usr_name_text);
		
		JLabel usr_sex = new JLabel("性别:");
		usr_sex.setBounds(54, 55, 30, 16);
		panel.add(usr_sex);
		
		JLabel usr_sex_text = new JLabel(usr.getSex());
		usr_sex_text.setBounds(170, 53, 100, 20);
		panel.add(usr_sex_text);
		
		JLabel usr_age_text = new JLabel(usr.getAge());
		usr_age_text.setBounds(170, 81, 100, 20);
		panel.add(usr_age_text);
		
		JLabel usr_age = new JLabel("年龄:");
		usr_age.setBounds(53, 81, 100, 20);
		panel.add(usr_age);
		
		JLabel usr_createdatetime = new JLabel("注册日期:");
		usr_createdatetime.setBounds(54, 145, 100, 20);
		panel.add(usr_createdatetime);
		
		JLabel usr_createdatetime_text = new JLabel(usr.getCreate_date());
		usr_createdatetime_text.setBounds(171, 145, 187, 20);
		panel.add(usr_createdatetime_text);
		
		JLabel usr_lastlogintiome = new JLabel("上次登陆日期:");
		usr_lastlogintiome.setBounds(54, 177, 100, 20);
		panel.add(usr_lastlogintiome);
		
		JLabel usr_lastlogintiome_text = new JLabel(usr.getLast_login_date());
		usr_lastlogintiome_text.setBounds(171, 177, 187, 20);
		panel.add(usr_lastlogintiome_text);
		
		JLabel label = new JLabel("邮箱:");
		label.setBounds(53, 113, 100, 20);
		panel.add(label);
		
		JLabel lblZxjlmcom = new JLabel("zxjlm233@163.com");
		lblZxjlmcom.setBounds(170, 113, 138, 20);
		panel.add(lblZxjlmcom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 83, 200, 350);
		jContentPane.add(panel_1);
				panel_1.setLayout(null);
		//		BackgroundPanel contentpanel = new BackgroundPanel();
				
				JButton btnsql = new JButton("数据库查询");
				btnsql.setBounds(45, 5, 109, 29);
				panel_1.add(btnsql);
				
				JButton btnana = new JButton("数据分析");
				btnana.setBounds(45, 67, 109, 29);
				panel_1.add(btnana);
				
				JButton button = new JButton("返回登录界面");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login lo = new Login();
						lo.setVisible(true);
						dispose();
					}
				});
				button.setBounds(45, 272, 117, 29);
				panel_1.add(button);
				
				JButton button_1 = new JButton("退出系统");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button_1.setBounds(45, 313, 117, 29);
				panel_1.add(button_1);
				
				btnana.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jump2ana(e);
					}
				});
				
				btnsql.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jump2sql(e);				
					}
				});
	}
	
	
	protected void jump2sql(ActionEvent e) {
		this.setVisible(false);
//		MainFrame t = new MainFrame();
//		t.setVisible(true);
	}
	
	protected void jump2ana(ActionEvent e) {
//		this.setVisible(false);
		AnalizeFrame t = new AnalizeFrame();
		t.setVisible(true);
	}
}
