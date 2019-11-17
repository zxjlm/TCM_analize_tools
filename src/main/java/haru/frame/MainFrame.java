package haru.frame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class MainFrame extends JFrame {
	private JPanel jContentPane;
	private JButton sqlModuleButton;
	private JButton analizeModuleButton;
	
	public static void main(String[] args) {
//		try {
//			String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
//			UIManager.setLookAndFeel(lookAndFeel);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainFrame() {
		this.setLayout(null);
		setForeground(Color.BLACK);
		setTitle("中医处方基础分析系统");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,500,500);
		
		jContentPane = new JPanel();
//		jContentPane.setLayout(new BorderLayout(0,0));
		jContentPane.setLayout(null);
		setContentPane(jContentPane);
//		BackgroundPanel contentpanel = new BackgroundPanel();
		
		JButton btnsql = new JButton("数据库查询");
		btnsql.setBounds(6,114,184,40);
		jContentPane.add(btnsql);
		
		JButton btnana = new JButton("数据分析");
		btnana.setBounds(6,174,184,40);
		jContentPane.add(btnana);
		
		
		btnsql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jump2sql(e);
				
			}
		});
		
		btnana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				jump2ana(e);
				
			}
		});
	}
	
	protected void jump2sql(ActionEvent e) {
		this.setVisible(false);
//		MainFrame t = new MainFrame();
//		t.setVisible(true);
	}
	
	protected void jump2ana(ActionEvent e) {
		this.setVisible(false);
		AnalizeFrame t = new AnalizeFrame();
		t.setVisible(true);
	}
	
}