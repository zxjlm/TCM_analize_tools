package haru.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.apache.commons.lang3.Validate;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import haru.utils.GFG;
import haru.utils.Mysql_handler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame{

	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("确认登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Mysql_handler.login_validate(textField.getText(), GFG.getSHA(String.valueOf(passwordField.getPassword())))) {
					MainFrame ma = new MainFrame();
					ma.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "登陆失败！用户名或密码错误", "登录结果", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(146, 189, 117, 29);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(173, 96, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("用户名:");
		label.setBounds(100, 101, 61, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setBounds(100, 129, 61, 16);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("中医处方基础分析系统");
		lblNewLabel.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(146, 34, 160, 29);
		getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 124, 130, 26);
		getContentPane().add(passwordField);
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp si = new SignUp();
				si.setVisible(true);
			}
		});
		button.setBounds(332, 101, 61, 29);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(297, 189, 69, 29);
		getContentPane().add(button_1);
	}
}
