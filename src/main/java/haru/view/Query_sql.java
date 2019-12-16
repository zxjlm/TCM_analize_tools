package haru.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Query_sql extends JFrame {
	
	//从数据库中取出信息
	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	//定义数据库需要的全局变量
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	
//	public static void main(String[] args) {
//		
//		Query_sql test2=new Query_sql();
// 
//	}
	//构造函数
		public Query_sql(){
			
			columnNames=new Vector();
			//设置列名
			columnNames.add("处方名");
			columnNames.add("添加日期");
			columnNames.add("添加人");
			columnNames.add("组成");
			
			rowData = new Vector();
			//rowData可以存放多行,开始从数据库里取
			
			try {
				//加载驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				//得到连接
				ct=DriverManager.getConnection("jdbc:mysql://39.108.229.166:3306/Java_sql?useSSL=false&useUnicode=true&characterEncoding=utf-8","root","root");
				
				ps=ct.prepareStatement("select * from tb_import_presciption");
				
				rs=ps.executeQuery();
				
				while(rs.next()){
					//rowData可以存放多行
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					hang.add(rs.getString(5));
					
					//加入到rowData
					rowData.add(hang);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				
					try {
						if(rs!=null){
						rs.close();
						}
						if(ps!=null){
							ps.close();
						}
						if(ct!=null){
							ct.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
						
			//初始化Jtable
			jt = new JTable(rowData,columnNames);
			
			//初始化 jsp
			jsp = new JScrollPane(jt);
			
			//把jsp放入到jframe
			this.add(jsp);
			
			this.setSize(400, 300);
			
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setVisible(true);
			
		}
}
