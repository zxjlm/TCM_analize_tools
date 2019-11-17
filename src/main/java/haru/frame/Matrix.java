package haru.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.alibaba.fastjson.JSONObject;

public class Matrix extends JFrame {
	
	public JSONObject js_response1;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Matrix frame = new Matrix();
//					frame.setVisible(true);
//					
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public Matrix(JSONObject js_response1) {
		// TODO Auto-generated constructor stub
		this.js_response1 = js_response1;
		
		
	}
}
