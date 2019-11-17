package haru.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.alibaba.fastjson.JSONObject;

public class Problllity extends JFrame{

	JSONObject js_response1,js_response2,js_response3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problllity frame = new Problllity();
					frame.setVisible(true);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
