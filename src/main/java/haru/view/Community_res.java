package haru.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

public class Community_res extends JFrame{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Community_res window = new Community_res();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Community_res() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 483, 562);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		textArea.setText(json2str_tt(DataImport.post_response5));
//		textArea.setText(json2str_tt("111"));
		getContentPane().add(textArea, "name_439811278586611");
	}
	
	
	public String json2str_tt(String s1) {
		
//		s1 = "{'社团0': ['乳香', '没药'], '社团1': ['桑椹', '生何首乌'], '社团2': ['党参', '鸡血藤', '焦白术', '生薏苡仁', '炙甘草', '仙鹤草', '茯苓', '蛇舌草'], '社团3': ['枇杷叶', '浙贝母', '前胡'], '社团4': ['炒谷芽', '炒麦芽'], '社团5': ['水牛角片', '紫草', '狗舌草', '生地黄', '丹皮'], '社团6': ['地', '生地榆'], '社团7': ['太子参', '麦冬'], '社团8': ['熟地黄', '怀牛膝', '千年健', '鹿角霜'], '社9': ['红花', '水红花子'], '社团10': ['槟榔', '沉香'], '社团11': ['禹余粮', '赤石脂'], '社团12': ['秦艽', '青风藤', '独活', '石楠藤'], '社团13': ['半枝莲'], '社团14': ['陈皮', '法半夏'], '社团15': ['木蝴蝶', '一枝黄花'], '社团16': ['汉防己', '葶苈子', '椒目'], '社团17': ['旱莲草', '女贞子'], '社团18': ['丝瓜络', '辛夷'], '社团19': ['泽泻', '泽兰'], '社团20': ['娑罗子', '佛手'], '社团21': ['银柴胡', '葎草'], '社团22': ['麻黄', '麻黄根'], '社团23': ['木防己', '大戟'], '社团24': ['黑丑', '商陆'], '社团25': ['金果榄', '山豆根'], '社团26': ['制草乌', '制川乌'], '社团27': ['金银花', '连翘', '香薷', '清水豆卷'], '社团28': ['煅龙骨', '煅牡蛎'], '社团29': ['半边莲', '紫花地丁']}";
		
		JSONObject js = new JSONObject();
		js = JSON.parseObject(s1);
		String output = "";
		
		List<String> cols = new ArrayList<>(js.keySet());
		for (int i = 0; i < cols.size(); i++) {
			Object j1 = js.get(cols.get(i));
			output += cols.get(i)+" -> "+j1.toString()+"\n" ;
		}
		
		return output; 
	}
}
