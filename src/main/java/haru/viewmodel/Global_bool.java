package haru.viewmodel;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Global_bool {
	public static boolean laberFlag1,labelFlag2,labelFlag3,labelFlag4,labelFlag5;
//	public static String url1 = "http://127.0.0.1:5000/admin/api/java_homework_01_matrix";
//	public static String url2 = "http://127.0.0.1:5000/admin/api/java_homework_content";
//	public static String url3 = "http://127.0.0.1:5000/admin/api/java_homework_pro";
//	
//	public static String url4 = "http://127.0.0.1:5000/admin/get_excel_recipe_html_java";
//	public static String url5 = "http://127.0.0.1:5000/admin/get_truely_network_graph";
//	39.108.229.166
	
	public static String url1 = "http://127.0.0.1:5000/admin/api/java_homework_01_matrix";
	public static String url2 = "http://127.0.0.1:5000/admin/api/java_homework_content";
	public static String url3 = "http://127.0.0.1:5000/admin/api/java_homework_pro";
	
	public static String url4 = "http://127.0.0.1:5000/admin/get_excel_recipe_html_java";
	public static String url5 = "http://127.0.0.1:5000/admin/get_truely_network_graph";
	
	public static String url6 = "http://127.0.0.1:5000/admin/network_from_tt/";
	public static String url7 = "http://127.0.0.1:5000/admin/community_from_tt/";
	
	public static String url8 = "http://127.0.0.1:5000/admin/community_from_tt_show_in_web";
	
	
	public static String url_dl = "http://127.0.0.1:5000/admin/api/v1.0/java/download";
	
	
	public static int win_width = 700;
	public static int win_height = 500;
	
	public static String[] cols = new String[] {"处方名","药名"};
	
	
	public static void init() {
		// TODO Auto-generated method stub
		labelFlag2 = false;
		laberFlag1 = false;
		labelFlag3 = false;
		labelFlag4 = false;
		labelFlag5 = false;
	}
	
	public static JSONObject myJson;
}
