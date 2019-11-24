package haru.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import haru.models.User;
import haru.utils.GFG;

public class SignUp extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("注册");
		setBounds(100, 100, 451, 514);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(96, 70, 61, 16);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(198, 70, 130, 26);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 100, 130, 26);
		getContentPane().add(textField_1);
		
		JLabel label = new JLabel("登录名");
		label.setBounds(96, 100, 61, 16);
		getContentPane().add(label);
		
		JLabel label_3 = new JLabel("密码");
		label_3.setBounds(96, 130, 61, 16);
		getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("确认密码");
		label_5.setBounds(96, 160, 61, 16);
		getContentPane().add(label_5);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("可选项");
		panel.setBounds(61, 226, 319, 137);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSex = new JLabel("性别");
		lblSex.setBounds(34, 51, 61, 16);
		panel.add(lblSex);
		
		JLabel label_2 = new JLabel("手机");
		label_2.setBounds(34, 21, 61, 16);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("年龄");
		label_4.setBounds(34, 81, 61, 16);
		panel.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(134, 81, 130, 26);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(134, 51, 130, 26);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 21, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 130, 130, 26);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(198, 160, 130, 26);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(188, 28, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JButton button = new JButton("确认注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))) {
					lblNewLabel_1.setForeground(Color.RED);
					lblNewLabel_1.setText("两次密码不一致");
				}else if (textField_1.getText().isEmpty() || textField.getText().isEmpty() || textField_2.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
					lblNewLabel_1.setForeground(Color.RED);
					lblNewLabel_1.setText("必填项不能为空");
				}else {
					sign_func();
				}
				
			}
		});
		button.setBounds(156, 385, 117, 29);
		getContentPane().add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 188, 130, 26);
		getContentPane().add(textField_2);
		
		JLabel label_1 = new JLabel("邮箱");
		label_1.setBounds(96, 188, 61, 16);
		getContentPane().add(label_1);
		
		
	}
	
	public void sign_func() {
		// TODO Auto-generated method stub
		Date date=new Date();
		User usr = new User(textField.getText(), textField_4.getText(), String.format("%tF%n", date)+" "+String.format("%tT%n",date), String.format("%tF%n", date)+" "+String.format("%tT%n",date), textField_5.getText(), textField_2.getText(), textField_1.getText(), textField_3.getText(), GFG.getSHA(String.valueOf(passwordField.getPassword())));
		Boolean res = usr.signin();
		
		if(res) {
			JOptionPane.showMessageDialog(null, "注册完成!", "注册结果", JOptionPane.PLAIN_MESSAGE);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "注册失败!请更换登录名", "注册结果", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
