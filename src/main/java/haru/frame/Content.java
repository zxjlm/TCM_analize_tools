package haru.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Content extends JFrame{
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Content frame = new Content();
					frame.setVisible(true);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
