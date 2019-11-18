package haru.frame;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import haru.utils.CsvToJsonUtil;
import haru.utils.HttpURLConnectionExample;
import haru.utils.global_bool;
import haru.utils.json2table;



public class AnalizeFrame extends JFrame {	
	private JPanel jContentPane;
	
	private JButton choiceButton;
	private JButton resultOf01Button;
	private JButton resultOfcontentButton;
	private JButton chartsOfcontentButton;
	private JButton resultOfprobilityButton;
	private JButton chartsOfProbilityButton;
	
	private JLabel matrixLabel;
	private JLabel contentLabel;
	private JLabel probilityLabel;
	
	public JLabel matrixLoder;
	public JLabel contentLoder;
	public JLabel probilityLoder;
	

	String post_response1 = "",post_response2="",post_response3="";
//	JSONObject js_response1,js_response2,js_response3;
	private JCheckBox choice_box1,choice_box2,choice_box3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalizeFrame frame = new AnalizeFrame();
					frame.setVisible(true);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AnalizeFrame() {

		
		
		this.setLayout(null);
		setForeground(Color.BLACK);
		setTitle("中医处方基础分析系统");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1000,1000);
		
		
		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		setContentPane(jContentPane);
		
		JButton btnfile = new JButton("文件选择(excel)");
		btnfile.setBounds(20,60,184,40);
		jContentPane.add(btnfile);
		
//		JButton btnchoice = new JButton("选择分析项");
//		btnchoice.setBounds(20,160,184,40);
//		jContentPane.add(btnchoice);
		
		resultOf01Button = new JButton("二值分析结果");
		resultOf01Button.setBounds(300,300,184,40);
		
		resultOfcontentButton = new JButton("成分分析结果");
		resultOfcontentButton.setBounds(300,400,184,40);
		chartsOfcontentButton = new JButton("成分分析图表");
		chartsOfcontentButton.setBounds(300,460,184,40);
		
		resultOfprobilityButton = new JButton("条件概率分析结果");
		resultOfprobilityButton.setBounds(300,560,184,40);
		chartsOfProbilityButton = new JButton("条件概率分析图表");
		chartsOfProbilityButton.setBounds(300,620,184,40);
		
		matrixLabel = new JLabel("二值矩阵");
		matrixLabel.setBounds(20,300,100,40);
		
		contentLabel = new JLabel("成分分析");
		contentLabel.setBounds(20,400,100,40);
		
		probilityLabel = new JLabel("条件概率分析");
		probilityLabel.setBounds(20,560,100,40);
		
		matrixLoder = new JLabel("1");
		matrixLoder.setBounds(150,300,100,40);
		
		contentLoder = new JLabel("1");
		contentLoder.setBounds(150,400,100,40);
		
		probilityLoder = new JLabel("1");
		probilityLoder.setBounds(150,560,100,40);
		
		matrixLoder.setVisible(true);
		contentLoder.setVisible(true);
		probilityLoder.setVisible(true);
		
		visable_init(false);
		jContentPane.add(matrixLabel);
		jContentPane.add(matrixLoder);
		jContentPane.add(probilityLabel);
		jContentPane.add(probilityLoder);
		jContentPane.add(contentLabel);
		jContentPane.add(contentLoder);
		jContentPane.add(resultOf01Button);
		jContentPane.add(resultOfcontentButton);
		jContentPane.add(resultOfprobilityButton);
		jContentPane.add(chartsOfcontentButton);
		jContentPane.add(chartsOfProbilityButton);
		
		
		btnfile.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				try {
					new labelControl1(matrixLoder).start();
					new labelControl2(contentLoder).start();
					new labelControl3(probilityLoder).start();
					resultOf01Button.setEnabled(false);
					resultOfcontentButton.setEnabled(false);
					resultOfprobilityButton.setEnabled(false);
					chartsOfcontentButton.setEnabled(false);
					chartsOfProbilityButton.setEnabled(false);

					visable_init(true);
					
					fileload();					
					
					resultOf01Button.setEnabled(true);
					resultOfcontentButton.setEnabled(true);
					resultOfprobilityButton.setEnabled(true);
					chartsOfcontentButton.setEnabled(true);
					chartsOfProbilityButton.setEnabled(true);
				} catch (IOException e1) {
					matrixLoder.setVisible(false);
					contentLoder.setVisible(false);
					probilityLoder.setVisible(false);
					visable_init(false);
					e1.printStackTrace();
				}
			}
		});
		
		resultOf01Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jump2matrix(e);
			}
		});
		
		
		resultOfcontentButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jump2content(e);
			}
		});
		
		
		resultOfprobilityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jump2probility(e);
			}
		});
		
		
		chartsOfcontentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Command="open "+global_bool.url4;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});


		chartsOfProbilityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Command="open "+global_bool.url5;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	
	public void fileload() throws IOException {
		System.out.println("load file ");
		
		global_bool.laberFlag1 = false;
		global_bool.labelFlag2 = false;
		global_bool.labelFlag3 = false;
		
		String filepath = "1",sj="";
		
		
		JFileChooser jf = new JFileChooser();
		try {
			jf.showOpenDialog(this); 	//显示
			File f =  jf.getSelectedFile();	//选择
			filepath = f.getAbsolutePath();	//路径名
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			sj = CsvToJsonUtil.json_str(filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		HttpURLConnectionExample poster1 = new HttpURLConnectionExample();
		try {
			post_response1 = poster1.sendPost(sj,global_bool.url1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("post1 over");
		
//		contentLoder.setText("Waiting");
		
//		js_response1 = new JSONObject();  
//		js_response1 = JSON.parseObject(post_response1);
		
		global_bool.laberFlag1 = true;
		
		
		
		
		
		HttpURLConnectionExample poster2 = new HttpURLConnectionExample();
		try {
			post_response2 = poster2.sendPost(sj,global_bool.url2);
			System.out.println(post_response2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(post_response2);
//		js_response2 = new JSONObject();  
//		js_response2 = JSON.parseObject(post_response2);
		
		global_bool.labelFlag2 = true;
		
		
		HttpURLConnectionExample poster3 = new HttpURLConnectionExample();
		try {
			post_response3 = poster3.sendPost(sj,global_bool.url3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		js_response3 = new JSONObject();  
//		js_response3 = JSON.parseObject(post_response3);
		
		global_bool.labelFlag3 = true;
		
		
		
        
    }
	
	protected void visable_init(Boolean flag) {
		resultOf01Button.setVisible(flag);

		resultOfcontentButton.setVisible(flag);
		chartsOfcontentButton.setVisible(flag);
		
		resultOfprobilityButton.setVisible(flag);
		chartsOfProbilityButton.setVisible(flag);
		
		matrixLabel.setVisible(flag);
		contentLabel.setVisible(flag);
		probilityLabel.setVisible(flag);
		

	}
	
	protected void jump2matrix(ActionEvent e) {
		json2table t = new json2table(post_response1,"二值分析");
		t.setVisible(true);
	}
	
	protected void jump2content(ActionEvent e) {
		json2table t = new json2table(post_response2,"成分分析");
		t.setVisible(true);
	}
	
	protected void jump2probility(ActionEvent e) {
		json2table t = new json2table(post_response3,"条件概率分析");
		t.setVisible(true);
	}
        
}

 class labelControl1 extends Thread{
	 public JLabel matrixLoder;
	 
	 public labelControl1(JLabel matrixLoder) {
		 this.matrixLoder = matrixLoder;
	 }

	@Override
	public void run() {
		String str = "Waiting " ;
		while(true) {
			if(global_bool.laberFlag1) {
				matrixLoder.setText("success");
				break;
			}
			System.out.println("111111");
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
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(global_bool.labelFlag2) {
					contentLoder.setText("success");
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
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(global_bool.labelFlag3) {
					probilityLoder.setText("success");
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



