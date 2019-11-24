package haru.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.alibaba.fastjson.JSONObject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import haru.utils.CsvToJsonUtil;
import haru.utils.HttpURLConnectionExample;
import haru.utils.Global_bool;
import haru.utils.Json2table;
import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class AnalizeFrame extends JFrame{
	private JPanel jContentPane;
	
//	private JButton choiceButton;
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
	
	public static String post_response1 = "",post_response2="",post_response3="",file_load_res="",filepath="",inputString = "";
//	JSONObject js_response1,js_response2,js_response3;
	private JCheckBox choice_box1,choice_box2,choice_box3;
	private JTable table_1;

	String [] arr;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AnalizeFrame window = new AnalizeFrame();
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
	public AnalizeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setLayout(null);
		setForeground(Color.BLACK);
		setTitle("中医处方基础分析系统");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200,100,1000,1000);
		
		
		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		setContentPane(jContentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(64, 33, 717, 255);
		jContentPane.add(tabbedPane);
		
//		JPanel combop = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		tabbedPane.add(p1,"文本输入");
		p1.setLayout(null);
		p1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 6, 684, 197);
		p1.add(textPane);
		
		tabbedPane.add(p2,"导入表单");
		p2.setLayout(null);
		
		JButton btnfile = new JButton("文件选择(csv)");
		btnfile.setBounds(290, 59, 125, 29);
		p2.add(btnfile);
		
		JTextPane txtpnLoading = new JTextPane();
		txtpnLoading.setBackground(Color.LIGHT_GRAY);
		txtpnLoading.setText("Loading...");
		txtpnLoading.setBounds(301, 118, 114, 16);
		p2.add(txtpnLoading);
		
		JScrollPane js=new JScrollPane(table_1);
		js.setVisible(true);
		jContentPane.add(js,BorderLayout.CENTER);
		
		JButton button = new JButton("确认提交");
		button.setBounds(594, 548, 170, 29);
		jContentPane.add(button);		
		
		matrixLabel = new JLabel("二值矩阵");
		matrixLabel.setBounds(124, 654, 52, 16);
		jContentPane.add(matrixLabel);
		
//		JButton btnchoice = new JButton("选择分析项");
//		btnchoice.setBounds(20,160,184,40);
//		jContentPane.add(btnchoice);
		
		resultOf01Button = new JButton("二值分析结果");
		resultOf01Button.setBounds(400, 654, 184, 40);
		resultOf01Button.setVisible(false);
		jContentPane.add(resultOf01Button);
		
		resultOfcontentButton = new JButton("成分分析结果");
		resultOfcontentButton.setBounds(400, 702, 184, 40);
		jContentPane.add(resultOfcontentButton);
		chartsOfcontentButton = new JButton("成分分析图表");
		chartsOfcontentButton.setBounds(400, 751, 184, 40);
		jContentPane.add(chartsOfcontentButton);
		
		resultOfprobilityButton = new JButton("条件概率分析结果");
		resultOfprobilityButton.setBounds(400, 816, 184, 40);
		jContentPane.add(resultOfprobilityButton); 
		chartsOfProbilityButton = new JButton("条件概率分析图表");
		chartsOfProbilityButton.setBounds(400, 855, 184, 40);
		jContentPane.add(chartsOfProbilityButton);
		
		probilityLabel = new JLabel("条件概率分析");
		probilityLabel.setBounds(124, 815, 100, 40);
		jContentPane.add(probilityLabel);
		
		contentLabel = new JLabel("成分分析");
		contentLabel.setBounds(124, 701, 100, 40);
		jContentPane.add(contentLabel);
		
		matrixLoder = new JLabel("");
		matrixLoder.setBounds(245, 654, 100, 40);
		jContentPane.add(matrixLoder);
		matrixLoder.setForeground(Color.RED);
		
		contentLoder = new JLabel("");
		contentLoder.setBounds(245, 706, 100, 40);
		jContentPane.add(contentLoder);
		contentLoder.setForeground(Color.RED);
		
		probilityLoder = new JLabel("");
		probilityLoder.setBounds(245, 815, 100, 40);
		jContentPane.add(probilityLoder);
		probilityLoder.setForeground(Color.RED);
		probilityLoder.setVisible(true);
		contentLoder.setVisible(true);
		
		matrixLoder.setVisible(true);
		
		visable_init(false);
		
		
		chartsOfProbilityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Command="open "+Global_bool.url5;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				String Command="open "+Global_bool.url4;
				try {
					Process Child=Runtime.getRuntime().exec(Command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnfile.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				try {
					file_load_res = fileload();
					
					table_1 = new JTable(table_init());
					table_1.setBounds(86, 285, 678, 251);
					table_1.setEnabled(false);
					jContentPane.add(table_1);
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
					txtpnLoading.setText("load success");
				} catch (IOException e1) {
					matrixLoder.setVisible(false);
					contentLoder.setVisible(false);
					probilityLoder.setVisible(false);
					visable_init(false);
					e1.printStackTrace();
				}
			}
		});
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new labelControl1(matrixLoder).start();
				new labelControl2(contentLoder).start();
				new labelControl3(probilityLoder).start();
				resultOf01Button.setEnabled(false);
				resultOfcontentButton.setEnabled(false);
				resultOfprobilityButton.setEnabled(false);
				chartsOfcontentButton.setEnabled(false);
				chartsOfProbilityButton.setEnabled(false);
				visable_init(true);
				
				new PostThread( file_load_res, inputString, arr, resultOf01Button, resultOfcontentButton, chartsOfcontentButton, chartsOfProbilityButton, resultOfprobilityButton).start();
			}
		});
		
		
		textPane.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (e.getDocument() == textPane.getDocument()) {
					Document doc = e.getDocument();
					String str = null;
					try {
						str = doc.getText(0, doc.getLength());
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					arr = str.split("\\s+");
					
					if (arr.length %2 == 0) {
						Object [] columnnames = {"处方名","药名"};
						Object a[][];
						
						a = new Object[arr.length/2][2];
						
						for (int j = 0; j < arr.length; j++) {
							a[j/2][j%2] = arr[j];
						}
						
						table_1 = new JTable(a,columnnames);
						table_1.setBounds(86, 285, 678, 251);
						table_1.setEnabled(false);
						jContentPane.add(table_1);
						table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		resultOfcontentButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jump2content(e);
			}
		});
		
		resultOf01Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jump2matrix(e);
			}
		});
	}
	
	
	public String fileload() throws IOException {
//		System.out.println("load file ");
		
		Global_bool.laberFlag1 = false;
		Global_bool.labelFlag2 = false;
		Global_bool.labelFlag3 = false;
		
		String sj="";
		
		
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
			System.out.println(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sj;
		
	}
	
	public void postAndGet(String sj) {
		HttpURLConnectionExample poster1 = new HttpURLConnectionExample();
		try {
			post_response1 = poster1.sendPost(sj,Global_bool.url1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Global_bool.laberFlag1 = true;
		
		HttpURLConnectionExample poster2 = new HttpURLConnectionExample();
		try {
			post_response2 = poster2.sendPost("",Global_bool.url2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Global_bool.labelFlag2 = true;
		
		HttpURLConnectionExample poster3 = new HttpURLConnectionExample();
		try {
			post_response3 = poster3.sendPost("",Global_bool.url3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Global_bool.labelFlag3 = true;
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
		
//		panel.setVisible(flag);
	}
	
	protected void jump2matrix(ActionEvent e) {
		Json2table t = new Json2table(post_response1,"二值分析");
		t.setVisible(true);
	}
	
	protected void jump2content(ActionEvent e) {
		Json2table t = new Json2table(post_response2,"成分分析");
		t.setVisible(true);
	}
	
	protected void jump2probility(ActionEvent e) {
		Json2table t = new Json2table(post_response3,"条件概率分析");
		t.setVisible(true);
	}
	
	public DefaultTableModel table_init() {
		Object[] columnnames;
		CSVReader CSVFileReader = null;
		try {
			CSVFileReader = new CSVReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List myEntries = null;
		try {
			myEntries = CSVFileReader.readAll();
		} catch (IOException | CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		columnnames = (String[]) myEntries.get(0);
		DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size()-1); 
		int rowcount = tableModel.getRowCount();
		for (int x = 0; x<rowcount+1; x++)
		{
		    int columnnumber = 0;
		    // if x = 0 this is the first row...skip it... data used for columnnames
		    if (x>0)
		    {
		        for (String thiscellvalue : (String[])myEntries.get(x))
		        {
//		        	System.out.println(thiscellvalue);
		            tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
		            columnnumber++;
		        }
		    }
		}
		System.out.println(tableModel);
		return tableModel;
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
	 }
		@Override
		public void run() {
			String str = "Waiting " ;
			while(true) {
				if(Global_bool.labelFlag3) {
					probilityLoder.setText("success");
					probilityLoder.setForeground(Color.GREEN);
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
	 private JButton resultOf01Button;
	private JButton resultOfcontentButton;
	private JButton chartsOfcontentButton;
	private JButton resultOfprobilityButton;
	private JButton chartsOfProbilityButton;
		
	public PostThread(String file_load_res,String inputString,String [] arr,JButton resultOf01Button,JButton resultOfcontentButton,JButton chartsOfcontentButton,JButton chartsOfProbilityButton,JButton resultOfprobilityButton) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		this.chartsOfcontentButton = chartsOfcontentButton;
		this.chartsOfProbilityButton = chartsOfProbilityButton;
		this.resultOf01Button = resultOf01Button;
		this.resultOfcontentButton = resultOfcontentButton;
		this.resultOfprobilityButton = resultOfprobilityButton;
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
			resultOf01Button.setEnabled(true);
			Global_bool.laberFlag1 = true;
			
			HttpURLConnectionExample poster2 = new HttpURLConnectionExample();
			try {
				AnalizeFrame.post_response2 = poster2.sendPost("",Global_bool.url2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultOfcontentButton.setEnabled(true);
			chartsOfcontentButton.setEnabled(true);
			Global_bool.labelFlag2 = true;
			
			HttpURLConnectionExample poster3 = new HttpURLConnectionExample();
			try {
				AnalizeFrame.post_response3 = poster3.sendPost("",Global_bool.url3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultOfprobilityButton.setEnabled(true);
			chartsOfProbilityButton.setEnabled(true);
			Global_bool.labelFlag3 = true;
		}
	 
 }
