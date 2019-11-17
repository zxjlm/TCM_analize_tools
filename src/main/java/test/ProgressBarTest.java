package test;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JProgressBar;


public class ProgressBarTest extends JFrame{

	private JProgressBar jpb = new JProgressBar();
	
	private JButton btn = new JButton("start");
	
	public ProgressBarTest() {
	
	setTitle("进度条");
	
	setSize(600, 500);
	
	setLocationRelativeTo(null);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setVisible(true);
	
	this.getContentPane().setLayout(new BorderLayout());
	
	jpb.setString("准备就绪。");
	
	jpb.setMinimum(0);
	
	jpb.setMaximum(100);
	
	jpb.setStringPainted(true);
	
	this.add(jpb,BorderLayout.SOUTH);
	
	this.add(btn,BorderLayout.NORTH);
	
	btn.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent actionevent) {
	
		new progressThread(jpb).start();

	}

}); 

}


	public static void main(String[] args) {
	
		new ProgressBarTest();
		
		}

}

	
class progressThread extends Thread {
	
	private JProgressBar jpb;
	
	public progressThread(JProgressBar jpb) {
	
		this.jpb = jpb;
	
	}
	
	public void run() {
	
		int max_amount = 100;
		
		int currentIndex = 0;
		
		while (currentIndex < max_amount) {
		
			currentIndex += 10;
			
			System.out.println(currentIndex);
			
			jpb.setValue(currentIndex);
			
			jpb.setString("已完成进度的" + currentIndex + "%");
		
		
			try {
			
				Thread.sleep(500);
			
			} catch (InterruptedException e) {
			
				// TODO Auto-generated catch block
			
				e.printStackTrace();
		
			}
		
		}
	
	}

}