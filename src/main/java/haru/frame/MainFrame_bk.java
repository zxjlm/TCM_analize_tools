//package haru.frame;
//
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import haru.utils.global_bool;
//
//
//
//
//public class MainFrame_bk extends JFrame {
//	private JPanel jContentPane;
//	private JButton sqlModuleButton;
//	private JButton analizeModuleButton;
//	
//	public static void main(String[] args) {
////		try {
////			String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
////			UIManager.setLookAndFeel(lookAndFeel);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame_bk frame = new MainFrame_bk();
//					frame.setVisible(true);
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public MainFrame_bk() {
//		this.setLayout(null);
//		setForeground(Color.BLACK);
//		setTitle("中医处方基础分析系统");
//		setResizable(false);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(200,100,global_bool.win_width,global_bool.win_height);
//		
//		jContentPane = new JPanel();
////		jContentPane.setLayout(new BorderLayout(0,0));
//		jContentPane.setLayout(null);
//		setContentPane(jContentPane);
////		BackgroundPanel contentpanel = new BackgroundPanel();
//		
//		JButton btnsql = new JButton("数据库查询");
//		btnsql.setBounds(6,114,184,40);
//		jContentPane.add(btnsql);
//		
//		JButton btnana = new JButton("数据分析");
//		btnana.setBounds(6,174,184,40);
//		jContentPane.add(btnana);
//		
//		
//		btnsql.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				jump2sql(e);
//				
//			}
//		});
//		
////		TODO:add usr info
//		JLabel usr_welcome = new JLabel("welcome ");
//		usr_welcome.setBounds(350,10,100,20);
//		jContentPane.add(usr_welcome);
//		
//		JLabel usr_name = new JLabel("姓名:");
//		usr_name.setBounds(250,100,100,20);
//		jContentPane.add(usr_name);
//		
//		JLabel usr_sex = new JLabel("性别");
//		usr_sex.setBounds(250,130,100,20);
//		jContentPane.add(usr_sex);
//		
//		JLabel usr_age = new JLabel("年龄");
//		usr_age.setBounds(250,160,100,20);
//		jContentPane.add(usr_age);
//		
//		JLabel usr_createdatetime = new JLabel("注册日期");
//		usr_createdatetime.setBounds(250,190,100,20);
//		jContentPane.add(usr_createdatetime);
//		
//		JLabel usr_lastlogintiome = new JLabel("上次登陆日期");
//		usr_lastlogintiome.setBounds(250,220,100,20);
//		jContentPane.add(usr_lastlogintiome);
//		
//		JLabel usr_name_text = new JLabel("姓名:");
//		usr_name_text.setBounds(400,100,100,20);
//		jContentPane.add(usr_name_text);
//		
//		JLabel usr_sex_text = new JLabel("性别");
//		usr_sex_text.setBounds(400,130,100,20);
//		jContentPane.add(usr_sex_text);
//		
//		JLabel usr_age_text = new JLabel("年龄");
//		usr_age_text.setBounds(400,160,100,20);
//		jContentPane.add(usr_age_text);
//		
//		JLabel usr_createdatetime_text = new JLabel("注册日期");
//		usr_createdatetime_text.setBounds(400,190,100,20);
//		jContentPane.add(usr_createdatetime_text);
//		
//		JLabel usr_lastlogintiome_text = new JLabel("上次登陆日期");
//		usr_lastlogintiome_text.setBounds(400,220,100,20);
//		jContentPane.add(usr_lastlogintiome_text);
//		
//		JLabel copyright = new JLabel("© 2019 Copyright  harumonia");
////		copyright.setBounds(global_bool.win_width /2 - 100,global_bool.win_height - 10,200,20);
//		copyright.setBounds(global_bool.win_width /2 - 100,global_bool.win_height - 50,200,20);
//		jContentPane.add(copyright);
//		
//		
//		
//		
//		btnana.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				jump2ana(e);
//				
//			}
//		});
//	}
//	
//	protected void jump2sql(ActionEvent e) {
//		this.setVisible(false);
////		MainFrame t = new MainFrame();
////		t.setVisible(true);
//	}
//	
//	protected void jump2ana(ActionEvent e) {
//		this.setVisible(false);
//		AnalizeFrame t = new AnalizeFrame();
//		t.setVisible(true);
//	}
//	
//}