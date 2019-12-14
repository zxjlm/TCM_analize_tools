package haru.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import haru.models.User;
import haru.utils.Global_bool;
import haru.utils.HttpURLConnectionExample;
import haru.utils.Json2table;
import javax.swing.JTextField;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.swing.JComboBox;

public class MainFrame extends JFrame{
	private JPanel jContentPane,panel,process_panel,link_panel,community_panel;
	private JButton sqlModuleButton;
	private JButton analizeModuleButton;
	public static JButton btn_community_ana_start,button_2;
	
	public static JLabel matrix01_loader,content_loader,probility_loader,link_loader,community_loader;
	public static JMenuItem content_table,content_chart,probility_table,probility_chart,link_table,community_table,community_chart,download;
	public static JComboBox comboBox_comnunity_1,comboBox_comnunity,comboBox_network;
	public static JButton btn_community,button_4,button_7;
		
	public static User usr;
	private JTextField textField;
	private JTextField textField_network;
	
	
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
		
		process_panel = new JPanel();
		process_panel.setBounds(262, 84, 403, 225);
		jContentPane.add(process_panel);
		process_panel.setLayout(null);
		
		JLabel content_lbl = new JLabel("成分分析");
		content_lbl.setBounds(50, 61, 61, 16);
		process_panel.add(content_lbl);
		
		JLabel probility_lbl = new JLabel("条件概率分析");
		probility_lbl.setBounds(50, 100, 86, 16);
		process_panel.add(probility_lbl);
		
		JLabel link_lbl = new JLabel("关联度分析");
		link_lbl.setBounds(50, 135, 77, 16);
		process_panel.add(link_lbl);
		
		JLabel community_lbl = new JLabel("社团分析");
		community_lbl.setBounds(50, 170, 61, 16);
		process_panel.add(community_lbl);
		
		matrix01_loader = new JLabel("waiting");
		matrix01_loader.setForeground(Color.RED);
		matrix01_loader.setBounds(229, 20, 86, 16);
		process_panel.add(matrix01_loader);
		
		content_loader = new JLabel("waiting");
		content_loader.setForeground(Color.RED);
		content_loader.setBounds(229, 61, 86, 16);
		process_panel.add(content_loader);
		
		probility_loader = new JLabel("waiting");
		probility_loader.setForeground(Color.RED);
		probility_loader.setBounds(229, 100, 86, 16);
		process_panel.add(probility_loader);
		
		link_loader = new JLabel("stop");
		link_loader.setForeground(Color.BLUE);
		link_loader.setBounds(229, 135, 86, 16);
		process_panel.add(link_loader);
		
		community_loader = new JLabel("stop");
		community_loader.setForeground(Color.BLUE);
		community_loader.setBounds(229, 170, 86, 16);
		process_panel.add(community_loader);
		
		JLabel matrixOf01 = new JLabel("二值分析");
		matrixOf01.setBounds(50, 20, 61, 16);
		process_panel.add(matrixOf01);
		
		link_panel = new JPanel();
		link_panel.setBounds(286, 84, 351, 240);
		jContentPane.add(link_panel);
		link_panel.setLayout(null);
		
		JLabel label_4 = new JLabel("置信度(0-1)");
		label_4.setBounds(34, 71, 117, 16);
		link_panel.add(label_4);
		
		JLabel label_5 = new JLabel("选择分析对象");
		label_5.setBounds(34, 28, 170, 16);
		link_panel.add(label_5); 
		
		textField_network = new JTextField();
		textField_network.setBounds(155, 66, 130, 26);
		link_panel.add(textField_network);
		textField_network.setColumns(10);
		
		button_2 = new JButton("开始分析");
		button_2.setBounds(90, 158, 117, 29);
		link_panel.add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(224, 163, 61, 16);
		link_panel.add(lblNewLabel);
		
		
		
		
		community_panel = new JPanel();
		community_panel.setBounds(296, 84, 392, 261);
		jContentPane.add(community_panel);
		community_panel.setLayout(null);
		
		JLabel lblstringListdata = new JLabel("社团划分对象1(选择列号)");
		lblstringListdata.setBounds(51, 65, 170, 16);
		community_panel.add(lblstringListdata);
		
//		comboBox_comnunity = new JComboBox();
		
		
		JLabel label_1 = new JLabel("社团划分对象2(选择列号)");
		label_1.setBounds(51, 110, 170, 16);
		community_panel.add(label_1);
		
//		comboBox_comnunity_1 = new JComboBox();
		
		
		JLabel label_2 = new JLabel("置信度(0-1)");
		label_2.setBounds(51, 161, 170, 16);
		community_panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(250, 156, 78, 26);
		community_panel.add(textField);
		textField.setColumns(10);
		
		btn_community_ana_start = new JButton("开始分析");
		btn_community_ana_start.setBounds(116, 210, 117, 29);
		community_panel.add(btn_community_ana_start);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(250, 215, 61, 16);
		community_panel.add(label_3);
		
		
		
		
		
		
//		TODO:add usr info
		JLabel usr_welcome = new JLabel("welcome "+usr.getName());
		usr_welcome.setBounds(513,31,139,20);
		jContentPane.add(usr_welcome);
		
		JLabel copyright = new JLabel("© 2019 Copyright  harumonia");
//		copyright.setBounds(global_bool.win_width /2 - 100,global_bool.win_height - 10,200,20);
		copyright.setBounds(Global_bool.win_width /2 - 100,Global_bool.win_height - 50,200,20);
		jContentPane.add(copyright);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 83, 200, 350);
		jContentPane.add(panel_1);
		panel_1.setLayout(null);
	//		BackgroundPanel contentpanel = new BackgroundPanel();
		
		JButton btnsql = new JButton("数据库查询");
		btnsql.setBounds(45, 5, 109, 29);
		panel_1.add(btnsql);
		
		JButton btnana = new JButton("数据录入");
		btnana.setBounds(45, 46, 109, 29);
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
		
		JButton button_6 = new JButton("待补充功能");
		button_6.setEnabled(false);
		button_6.setBounds(45, 219, 109, 29);
		panel_1.add(button_6);
		
		button_7 = new JButton("查看分析进度");
		button_7.setEnabled(false);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_init();
				process_panel.setVisible(true);
			}
		});
		button_7.setBounds(45, 169, 117, 29);
		panel_1.add(button_7);
		
		btn_community = new JButton("社团分析");
		btn_community.setEnabled(false);
		btn_community.setBounds(45, 128, 117, 29);
		panel_1.add(btn_community);
		
		button_4 = new JButton("关联度分析");
		button_4.setEnabled(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_init();
				link_panel.setVisible(true);
				
				comboBox_network = new JComboBox<String>(Global_bool.cols);;
				comboBox_network.setBounds(155, 24, 130, 27);
				link_panel.add(comboBox_network);
			}
		});
		button_4.setBounds(45, 87, 117, 29);
		panel_1.add(button_4);
		
		panel = new JPanel();
		panel.setBounds(273, 84, 364, 225);
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
		
		
		//加入菜单
		JMenuBar menuBar = new JMenuBar();
		JMenu file_menu = new JMenu("文件(F)");
		JMenu edit_menu = new JMenu("编辑(E)");
		JMenu show_menu = new JMenu("分析结果(E)");

		
		JMenuItem open = new JMenuItem("打开");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_init();
				process_panel.setVisible(true);
				jump2ana(e);
			}
		});
		download = new JMenuItem("下载");
		download.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Command="open "+Global_bool.url_dl;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		download.setEnabled(false);
	    JMenuItem quit = new JMenuItem("退出");
	    
	    content_table = new JMenuItem("成分分析");
	    content_table.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		jump2content(e);
	    	}
	    });
	    content_table.setEnabled(false);
	    content_chart = new JMenuItem("成分分析(图)");
	    content_chart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String Command="open "+Global_bool.url4;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    content_chart.setEnabled(false);
	    
	    probility_table = new JMenuItem("条件概率分析");
	    probility_table.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		jump2probility(e);
	    	}
	    });
	    probility_table.setEnabled(false);
	    
	    probility_chart = new JMenuItem("条件概率分析(图)");
	    probility_chart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String Command="open "+Global_bool.url5;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    probility_chart.setEnabled(false);
	    link_table = new JMenuItem("关联度分析");
	    link_table.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		jump2network(e);
	    	}
	    });
	    link_table.setEnabled(false);
	    community_table = new JMenuItem("社团分析");
	    community_table.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		jump2community(e);
	    	}
	    });
	    community_table.setEnabled(false);
	    community_chart = new JMenuItem("社团分析(图)");
	    community_chart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String Command="open "+Global_bool.url8;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    community_chart.setEnabled(false);
		
	    file_menu.add(open);
	    file_menu.add(download);
	      // 设置菜单分隔符
	    file_menu.addSeparator();
	    file_menu.add(quit);
	    
	    
	    show_menu.add(content_table);
	    show_menu.add(content_chart);
	    show_menu.add(probility_table);
	    show_menu.add(probility_chart);
	    show_menu.add(link_table);
	    show_menu.add(community_table);
	    show_menu.add(community_chart);
	    
	    menuBar.add(file_menu);
	    menuBar.add(edit_menu);
	    menuBar.add(show_menu);
	    
	    
		setJMenuBar(menuBar);
		
//		定义分界线
		
		
		panel_init();
		panel.setVisible(true);
		
		
		btnana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_init();
				process_panel.setVisible(true);
				jump2ana(e);
			}
		});
		
		btnsql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jump2sql(e);				
			}
		});
		
		btn_community.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_init();
				community_panel.setVisible(true);
				
				comboBox_comnunity = new JComboBox<String>(Global_bool.cols);
				comboBox_comnunity.setBounds(240, 61, 97, 27);
				community_panel.add(comboBox_comnunity);
				
				comboBox_comnunity_1 = new JComboBox<String>(Global_bool.cols);
				comboBox_comnunity_1.setBounds(240, 106, 97, 27);
				community_panel.add(comboBox_comnunity_1);
			}
		});
		
		btn_community_ana_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_3.setText("");
				double confidence = Double.parseDouble(textField.getText());
				if(confidence<0 || confidence>1) {
					label_3.setText("置信度错误");
				}
				new PostThread_community(comboBox_comnunity.getSelectedItem().toString(),comboBox_comnunity_1.getSelectedItem().toString(),textField.getText()).start();
				new labelControl5(community_loader).start();
				btn_community_ana_start.setText("已开始分析");
				btn_community_ana_start.setEnabled(false);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
				double confidence = Double.parseDouble(textField_network.getText());
				if(confidence<0 || confidence>1) {
					lblNewLabel.setText("置信度错误");
				}
				new PostThread_network(comboBox_network.getSelectedItem().toString(), textField_network.getText()).start();
				new labelControl4(link_loader).start();
				button_2.setText("已开始分析");
				button_2.setEnabled(false);
			}
		});
	}
	
	
	protected void jump2sql(ActionEvent e) {
//		this.setVisible(false);
//		MainFrame t = new MainFrame();
//		t.setVisible(true);
	}
	
	protected void jump2ana(ActionEvent e) {
//		this.setVisible(false);
		AnalizeFrame t = new AnalizeFrame();
		t.setVisible(true);
	}
	
	
	protected void jump2content(ActionEvent e) {
		Json2table t = new Json2table(AnalizeFrame.post_response2,"成分分析");
		t.setVisible(true);
	}
	
	protected void jump2community(ActionEvent e) {
		Community_res t = new Community_res();
		t.setVisible(true);
	}
	
	protected void jump2probility(ActionEvent e) {
		Json2table t = new Json2table(AnalizeFrame.post_response3,"条件概率分析");
		t.setVisible(true);
	}
	
	protected void jump2network(ActionEvent e) {
		Network_frame t = new Network_frame();
		t.setVisible(true);
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void panel_init() {
		panel.setVisible(false);
		process_panel.setVisible(false);
		community_panel.setVisible(false);
		link_panel.setVisible(false);
	}
	
	
//	TODO:
//	待归并
	
}


class labelControl1 extends Thread{
	 public JLabel matrixLoder;
	 
	 public labelControl1(JLabel matrixLoder) {
		 this.matrixLoder = matrixLoder;
		 matrixLoder.setForeground(Color.RED);
	 }

	@Override
	public void run() {
		String str = "Waiting " ;
		while(true) {
			if(Global_bool.laberFlag1) {
				matrixLoder.setText("success");
				matrixLoder.setForeground(Color.GREEN);
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(str.equals("Waiting ......")) {
				str = "Waiting ";
			}
			str += ".";
			matrixLoder.setText(str);
		}
	}

}

class labelControl2 extends Thread{
	 public JLabel contentLoder;
	 
	 public labelControl2(JLabel contentLoder) {
		 this.contentLoder = contentLoder;
		 contentLoder.setForeground(Color.RED);
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(Global_bool.labelFlag2) {
					contentLoder.setText("success");
					contentLoder.setForeground(Color.GREEN);
					break;
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(str.equals("Waiting ......")) {
					str = "Waiting ";
				}
				str += ".";
				contentLoder.setText(str);
			}
		}

	}


class labelControl3 extends Thread{
	 public JLabel probilityLoder;
	 
	 public labelControl3(JLabel probilityLoder) {
		 this.probilityLoder = probilityLoder;
		 probilityLoder.setForeground(Color.RED);
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(Global_bool.labelFlag3) {
					probilityLoder.setText("success");
					probilityLoder.setForeground(Color.GREEN);
					MainFrame.download.setEnabled(true);
					break;
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(str.equals("Waiting ......")) {
					str = "Waiting ";
				}
				str += ".";
				probilityLoder.setText(str);
			}
		}

	}

class labelControl4 extends Thread{
	 public JLabel probilityLoder;
	 
	 public labelControl4(JLabel probilityLoder) {
		 this.probilityLoder = probilityLoder;
		 probilityLoder.setForeground(Color.RED);
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(Global_bool.labelFlag4) {
					probilityLoder.setText("success");
					probilityLoder.setForeground(Color.GREEN);
					MainFrame.btn_community_ana_start.setEnabled(true);
					MainFrame.btn_community_ana_start.setText("开始分析");
					break;
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(str.equals("Waiting ......")) {
					str = "Waiting ";
				}
				str += ".";
				probilityLoder.setText(str);
			}
		}

	}

class labelControl5 extends Thread{
	 public JLabel probilityLoder;
	 
	 public labelControl5(JLabel probilityLoder) {
		 this.probilityLoder = probilityLoder;
		 probilityLoder.setForeground(Color.RED);
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(Global_bool.labelFlag5) {
					probilityLoder.setText("success");
					probilityLoder.setForeground(Color.GREEN);
					MainFrame.button_2.setEnabled(true);
					MainFrame.button_2.setText("开始分析");
					break;
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(str.equals("Waiting ......")) {
					str = "Waiting ";
				}
				str += ".";
				probilityLoder.setText(str);
			}
		}

	}





class PostThread extends Thread{
	 private String file_load_res,inputString;
	 private String [] arr;
//	 private JButton resultOf01Button;
	 private JMenuItem content_table,content_chart,probility_table,probility_chart;
		
	public PostThread(String file_load_res,String inputString,String [] arr,JMenuItem content_table,JMenuItem content_chart,JMenuItem probility_table,JMenuItem probility_chart) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		
		this.content_chart = content_chart;
		this.content_table = content_table;
		this.probility_chart = probility_chart;
		this.probility_table = probility_table;
		
		this.file_load_res = file_load_res;
		this.inputString = inputString;
	}
	
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		if(file_load_res.isEmpty()) {
			inputString += "[";
			for (int i = 0; i < arr.length; i+=2) {
				inputString+=("{\"处方名\":\""+arr[i]+"\",\"组成\":\""+arr[i+1]+"\"},");
			}
			inputString=inputString.substring(0,inputString.length()-1).replace("，", ",")+"]";
			System.out.println(inputString);
			
			postAndGet(inputString);
		} else {
			postAndGet(file_load_res);
		}
	}
	 
	 public void postAndGet(String sj) {
		 HttpURLConnectionExample poster1 = new HttpURLConnectionExample();;	
		 	try {
				AnalizeFrame.post_response1 = poster1.sendPost(sj,Global_bool.url1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			resultOf01Button.setEnabled(true);
			Global_bool.laberFlag1 = true;
			
			HttpURLConnectionExample poster2 = new HttpURLConnectionExample();
			try {
				AnalizeFrame.post_response2 = poster2.sendPost("",Global_bool.url2);
				System.out.println("content over");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content_chart.setEnabled(true);
			content_table.setEnabled(true);
			Global_bool.labelFlag2 = true;
			
			HttpURLConnectionExample poster3 = new HttpURLConnectionExample();
			try {
				AnalizeFrame.post_response3 = poster3.sendPost("",Global_bool.url3);
				System.out.println("probility over");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			probility_chart.setEnabled(true);
			probility_table.setEnabled(true);
			Global_bool.labelFlag3 = true;
			
		}
	 
}


class PostThread_community extends Thread{
	private String a,b,c;
	
	public PostThread_community(String a,String b,String c) {
		this.setA(a);
		this.setB(b);
		this.setC(c);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		postAndGet();
	}
	
	public void postAndGet() {
		HttpURLConnectionExample poster5 = new HttpURLConnectionExample();
		try {
			AnalizeFrame.post_response5 = poster5.sendPost("",Global_bool.url7+a+"/"+b+"/"+c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.community_table.setEnabled(true);
		MainFrame.community_chart.setEnabled(true);
		Global_bool.labelFlag5 = true;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
}


class PostThread_network extends Thread{
	private String a,c;
	
	public PostThread_network(String a,String c) {
		this.setA(a);
		this.setC(c);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		postAndGet();
	}
	
	public void postAndGet() {
		HttpURLConnectionExample poster4 = new HttpURLConnectionExample();
		try {
			System.out.println(Global_bool.url6+a+"/"+c);
			AnalizeFrame.post_response4 = poster4.sendPost("",Global_bool.url6+a+"/"+c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.link_table.setEnabled(true);
//		MainFrame.community_chart.setEnabled(true);
		Global_bool.labelFlag4 = true;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
}




