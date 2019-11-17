package test;

import haru.utils.global_bool;

import java.io.IOException;
import java.lang.Runtime;

public class BareBonesBrowserLaunch {
	
	public static void main(String[] args) {
		String Command="open "+global_bool.url4;
		try {
			Process Child=Runtime.getRuntime().exec(Command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
