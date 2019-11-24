package test;

import haru.utils.Global_bool;

import java.io.IOException;
import java.lang.Runtime;

public class BareBonesBrowserLaunch {
	
	public static void main(String[] args) {
		String Command="open "+Global_bool.url4;
		try {
			Process Child=Runtime.getRuntime().exec(Command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
