package haru.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("确认登录");
		btnNewButton.setBounds(146, 189, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(214, 96, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("用户名:");
		label.setBounds(100, 101, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setBounds(100, 129, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("某不愿透露姓名的zxj制作的登录界面啊");
		lblNewLabel.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(100, 34, 266, 29);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 134, 130, 26);
		frame.getContentPane().add(passwordField);
	}
}
