package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

public class Json_try{

	public static void main(String[] args) {
		WinTable tb = new WinTable();
	}
	
}


class WinTable extends JFrame{
	JTable tb;
	Object a[][],b[];
	
	public WinTable() {
		// TODO Auto-generated constructor stub
		String js = "[{\"right\": \"炙甘草\", \"left\": \"鸡血藤\", \"confidence\": 0.6462346760070052}, {\"right\": \"炙甘草\", \"left\": \"仙鹤草\", \"confidence\": 0.7009063444108762}, {\"right\": \"炙甘草\", \"left\": \"生薏苡仁\", \"confidence\": 0.7186147186147186}, {\"right\": \"炙甘草\", \"left\": \"焦白术\", \"confidence\": 0.8129952456418383}, {\"right\": \"炙甘草\", \"left\": \"茯苓\", \"confidence\": 0.8045801526717558}, {\"right\": \"炙甘草\", \"left\": \"党参\", \"confidence\": 0.7828746177370031}, {\"right\": \"香薷\", \"left\": \"金银花\", \"confidence\": 1.0}, {\"right\": \"香薷\", \"left\": \"连翘\", \"confidence\": 1.0}, {\"right\": \"香薷\", \"left\": \"清水豆卷\", \"confidence\": 1.0}, {\"right\": \"紫草\", \"left\": \"狗舌草\", \"confidence\": 0.6136363636363636}, {\"right\": \"紫草\", \"left\": \"丹皮\", \"confidence\": 0.6470588235294118}, {\"right\": \"紫草\", \"left\": \"水牛角片\", \"confidence\": 0.8157894736842105}, {\"right\": \"制草乌\", \"left\": \"制川乌\", \"confidence\": 1.0}, {\"right\": \"红花\", \"left\": \"水红花子\", \"confidence\": 0.9827586206896551}, {\"right\": \"木蝴蝶\", \"left\": \"一枝黄花\", \"confidence\": 1.0}, {\"right\": \"丝瓜络\", \"left\": \"辛夷\", \"confidence\": 0.6190476190476191}, {\"right\": \"水红花子\", \"left\": \"红花\", \"confidence\": 0.9827586206896551}, {\"right\": \"金果榄\", \"left\": \"山豆根\", \"confidence\": 1.0}, {\"right\": \"槟榔\", \"left\": \"沉香\", \"confidence\": 0.625}, {\"right\": \"女贞子\", \"left\": \"旱莲草\", \"confidence\": 0.8795811518324608}, {\"right\": \"商陆\", \"left\": \"黑丑\", \"confidence\": 0.8}, {\"right\": \"佛手\", \"left\": \"娑罗子\", \"confidence\": 0.75}, {\"right\": \"炒麦芽\", \"left\": \"炒谷芽\", \"confidence\": 0.8571428571428571}, {\"right\": \"椒目\", \"left\": \"汉防己\", \"confidence\": 0.8181818181818182}, {\"right\": \"椒目\", \"left\": \"葶苈子\", \"confidence\": 0.76}, {\"right\": \"独活\", \"left\": \"石楠藤\", \"confidence\": 0.75}, {\"right\": \"独活\", \"left\": \"秦艽\", \"confidence\": 0.75}, {\"right\": \"鸡血藤\", \"left\": \"炙甘草\", \"confidence\": 0.6462346760070052}, {\"right\": \"鸡血藤\", \"left\": \"仙鹤草\", \"confidence\": 0.6329305135951662}, {\"right\": \"鸡血藤\", \"left\": \"生薏苡仁\", \"confidence\": 0.6132756132756133}, {\"right\": \"鸡血藤\", \"left\": \"焦白术\", \"confidence\": 0.624405705229794}, {\"right\": \"鸡血藤\", \"left\": \"茯苓\", \"confidence\": 0.6061068702290077}, {\"right\": \"鸡血藤\", \"left\": \"党参\", \"confidence\": 0.6422018348623854}, {\"right\": \"泽泻\", \"left\": \"泽兰\", \"confidence\": 0.6714285714285714}, {\"right\": \"大戟\", \"left\": \"木防己\", \"confidence\": 1.0}, {\"right\": \"仙鹤草\", \"left\": \"炙甘草\", \"confidence\": 0.7009063444108762}, {\"right\": \"仙鹤草\", \"left\": \"鸡血藤\", \"confidence\": 0.6329305135951662}, {\"right\": \"仙鹤草\", \"left\": \"生薏苡仁\", \"confidence\": 0.8095238095238095}, {\"right\": \"仙鹤草\", \"left\": \"焦白术\", \"confidence\": 0.7900302114803626}, {\"right\": \"仙鹤草\", \"left\": \"蛇舌草\", \"confidence\": 0.6631419939577039}, {\"right\": \"仙鹤草\", \"left\": \"茯苓\", \"confidence\": 0.770392749244713}, {\"right\": \"仙鹤草\", \"left\": \"党参\", \"confidence\": 0.8126888217522659}, {\"right\": \"怀牛膝\", \"left\": \"千年健\", \"confidence\": 0.7058823529411765}, {\"right\": \"怀牛膝\", \"left\": \"熟地黄\", \"confidence\": 0.7142857142857143}, {\"right\": \"一枝黄花\", \"left\": \"木蝴蝶\", \"confidence\": 1.0}, {\"right\": \"金银花\", \"left\": \"香薷\", \"confidence\": 1.0}, {\"right\": \"金银花\", \"left\": \"连翘\", \"confidence\": 1.0}, {\"right\": \"金银花\", \"left\": \"清水豆卷\", \"confidence\": 1.0}, {\"right\": \"鹿角霜\", \"left\": \"熟地黄\", \"confidence\": 0.6153846153846154}, {\"right\": \"娑罗子\", \"left\": \"佛手\", \"confidence\": 0.75}, {\"right\": \"没药\", \"left\": \"乳香\", \"confidence\": 0.8888888888888888}, {\"right\": \"生薏苡仁\", \"left\": \"炙甘草\", \"confidence\": 0.7186147186147186}, {\"right\": \"生薏苡仁\", \"left\": \"鸡血藤\", \"confidence\": 0.6132756132756133}, {\"right\": \"生薏苡仁\", \"left\": \"仙鹤草\", \"confidence\": 0.8095238095238095}, {\"right\": \"生薏苡仁\", \"left\": \"焦白术\", \"confidence\": 0.7691197691197691}, {\"right\": \"生薏苡仁\", \"left\": \"蛇舌草\", \"confidence\": 0.6363636363636364}, {\"right\": \"生薏苡仁\", \"left\": \"茯苓\", \"confidence\": 0.7806637806637806}, {\"right\": \"生薏苡仁\", \"left\": \"党参\", \"confidence\": 0.8080808080808081}, {\"right\": \"煅龙骨\", \"left\": \"煅牡蛎\", \"confidence\": 0.6363636363636364}, {\"right\": \"千年健\", \"left\": \"怀牛膝\", \"confidence\": 0.7058823529411765}, {\"right\": \"山豆根\", \"left\": \"金果榄\", \"confidence\": 1.0}, {\"right\": \"制川乌\", \"left\": \"制草乌\", \"confidence\": 1.0}, {\"right\": \"辛夷\", \"left\": \"丝瓜络\", \"confidence\": 0.6190476190476191}, {\"right\": \"麻黄\", \"left\": \"麻黄根\", \"confidence\": 0.8571428571428571}, {\"right\": \"熟地黄\", \"left\": \"怀牛膝\", \"confidence\": 0.7142857142857143}, {\"right\": \"熟地黄\", \"left\": \"鹿角霜\", \"confidence\": 0.6153846153846154}, {\"right\": \"浙贝母\", \"left\": \"前胡\", \"confidence\": 0.7777777777777778}, {\"right\": \"连翘\", \"left\": \"香薷\", \"confidence\": 1.0}, {\"right\": \"连翘\", \"left\": \"金银花\", \"confidence\": 1.0}, {\"right\": \"连翘\", \"left\": \"清水豆卷\", \"confidence\": 1.0}, {\"right\": \"汉防己\", \"left\": \"椒目\", \"confidence\": 0.8181818181818182}, {\"right\": \"汉防己\", \"left\": \"葶苈子\", \"confidence\": 0.72}, {\"right\": \"麦冬\", \"left\": \"太子参\", \"confidence\": 0.6710182767624021}, {\"right\": \"乳香\", \"left\": \"没药\", \"confidence\": 0.8888888888888888}, {\"right\": \"清水豆卷\", \"left\": \"香薷\", \"confidence\": 1.0}, {\"right\": \"清水豆卷\", \"left\": \"金银花\", \"confidence\": 1.0}, {\"right\": \"清水豆卷\", \"left\": \"连翘\", \"confidence\": 1.0}, {\"right\": \"黑丑\", \"left\": \"商陆\", \"confidence\": 0.8}, {\"right\": \"炒谷芽\", \"left\": \"炒麦芽\", \"confidence\": 0.8571428571428571}, {\"right\": \"桑椹\", \"left\": \"生何首乌\", \"confidence\": 0.7894736842105263}, {\"right\": \"旱莲草\", \"left\": \"女贞子\", \"confidence\": 0.8795811518324608}, {\"right\": \"焦白术\", \"left\": \"炙甘草\", \"confidence\": 0.8129952456418383}, {\"right\": \"焦白术\", \"left\": \"鸡血藤\", \"confidence\": 0.624405705229794}, {\"right\": \"焦白术\", \"left\": \"仙鹤草\", \"confidence\": 0.7900302114803626}, {\"right\": \"焦白术\", \"left\": \"生薏苡仁\", \"confidence\": 0.7691197691197691}, {\"right\": \"焦白术\", \"left\": \"蛇舌草\", \"confidence\": 0.6164817749603804}, {\"right\": \"焦白术\", \"left\": \"茯苓\", \"confidence\": 0.8030534351145038}, {\"right\": \"焦白术\", \"left\": \"党参\", \"confidence\": 0.8287461773700305}, {\"right\": \"陈皮\", \"left\": \"法半夏\", \"confidence\": 0.6320754716981132}, {\"right\": \"半边莲\", \"left\": \"紫花地丁\", \"confidence\": 1.0}, {\"right\": \"石楠藤\", \"left\": \"独活\", \"confidence\": 0.75}, {\"right\": \"石楠藤\", \"left\": \"青风藤\", \"confidence\": 0.6666666666666666}, {\"right\": \"石楠藤\", \"left\": \"秦艽\", \"confidence\": 1.0}, {\"right\": \"沉香\", \"left\": \"槟榔\", \"confidence\": 0.625}, {\"right\": \"蛇舌草\", \"left\": \"仙鹤草\", \"confidence\": 0.6631419939577039}, {\"right\": \"蛇舌草\", \"left\": \"生薏苡仁\", \"confidence\": 0.6363636363636364}, {\"right\": \"蛇舌草\", \"left\": \"焦白术\", \"confidence\": 0.6164817749603804}, {\"right\": \"蛇舌草\", \"left\": \"半枝莲\", \"confidence\": 0.6642335766423357}, {\"right\": \"葎草\", \"left\": \"银柴胡\", \"confidence\": 0.75}, {\"right\": \"狗舌草\", \"left\": \"紫草\", \"confidence\": 0.6136363636363636}, {\"right\": \"狗舌草\", \"left\": \"水牛角片\", \"confidence\": 0.6136363636363636}, {\"right\": \"法半夏\", \"left\": \"陈皮\", \"confidence\": 0.6320754716981132}, {\"right\": \"禹余粮\", \"left\": \"赤石脂\", \"confidence\": 0.8181818181818182}, {\"right\": \"丹皮\", \"left\": \"紫草\", \"confidence\": 0.6470588235294118}, {\"right\": \"丹皮\", \"left\": \"水牛角片\", \"confidence\": 0.7450980392156863}, {\"right\": \"丹皮\", \"left\": \"生地黄\", \"confidence\": 0.6172839506172839}, {\"right\": \"半枝莲\", \"left\": \"蛇舌草\", \"confidence\": 0.6642335766423357}, {\"right\": \"水牛角片\", \"left\": \"紫草\", \"confidence\": 0.8157894736842105}, {\"right\": \"水牛角片\", \"left\": \"狗舌草\", \"confidence\": 0.6136363636363636}, {\"right\": \"水牛角片\", \"left\": \"丹皮\", \"confidence\": 0.7450980392156863}, {\"right\": \"木防己\", \"left\": \"大戟\", \"confidence\": 1.0}, {\"right\": \"地榆\", \"left\": \"生地榆\", \"confidence\": 0.75}, {\"right\": \"前胡\", \"left\": \"浙贝母\", \"confidence\": 0.7777777777777778}, {\"right\": \"前胡\", \"left\": \"枇杷叶\", \"confidence\": 0.7142857142857143}, {\"right\": \"茯苓\", \"left\": \"炙甘草\", \"confidence\": 0.8045801526717558}, {\"right\": \"茯苓\", \"left\": \"鸡血藤\", \"confidence\": 0.6061068702290077}, {\"right\": \"茯苓\", \"left\": \"仙鹤草\", \"confidence\": 0.770392749244713}, {\"right\": \"茯苓\", \"left\": \"生薏苡仁\", \"confidence\": 0.7806637806637806}, {\"right\": \"茯苓\", \"left\": \"焦白术\", \"confidence\": 0.8030534351145038}, {\"right\": \"茯苓\", \"left\": \"党参\", \"confidence\": 0.815267175572519}, {\"right\": \"葶苈子\", \"left\": \"椒目\", \"confidence\": 0.76}, {\"right\": \"葶苈子\", \"left\": \"汉防己\", \"confidence\": 0.72}, {\"right\": \"赤石脂\", \"left\": \"禹余粮\", \"confidence\": 0.8181818181818182}, {\"right\": \"银柴胡\", \"left\": \"葎草\", \"confidence\": 0.75}, {\"right\": \"麻黄根\", \"left\": \"麻黄\", \"confidence\": 0.8571428571428571}, {\"right\": \"枇杷叶\", \"left\": \"前胡\", \"confidence\": 0.7142857142857143}, {\"right\": \"青风藤\", \"left\": \"石楠藤\", \"confidence\": 0.6666666666666666}, {\"right\": \"青风藤\", \"left\": \"秦艽\", \"confidence\": 0.6666666666666666}, {\"right\": \"秦艽\", \"left\": \"独活\", \"confidence\": 0.75}, {\"right\": \"秦艽\", \"left\": \"石楠藤\", \"confidence\": 1.0}, {\"right\": \"秦艽\", \"left\": \"青风藤\", \"confidence\": 0.6666666666666666}, {\"right\": \"生地榆\", \"left\": \"地榆\", \"confidence\": 0.75}, {\"right\": \"煅牡蛎\", \"left\": \"煅龙骨\", \"confidence\": 0.6363636363636364}, {\"right\": \"生地黄\", \"left\": \"丹皮\", \"confidence\": 0.6172839506172839}, {\"right\": \"党参\", \"left\": \"炙甘草\", \"confidence\": 0.7828746177370031}, {\"right\": \"党参\", \"left\": \"鸡血藤\", \"confidence\": 0.6422018348623854}, {\"right\": \"党参\", \"left\": \"仙鹤草\", \"confidence\": 0.8126888217522659}, {\"right\": \"党参\", \"left\": \"生薏苡仁\", \"confidence\": 0.8080808080808081}, {\"right\": \"党参\", \"left\": \"焦白术\", \"confidence\": 0.8287461773700305}, {\"right\": \"党参\", \"left\": \"茯苓\", \"confidence\": 0.815267175572519}, {\"right\": \"生何首乌\", \"left\": \"桑椹\", \"confidence\": 0.7894736842105263}, {\"right\": \"紫花地丁\", \"left\": \"半边莲\", \"confidence\": 1.0}, {\"right\": \"太子参\", \"left\": \"麦冬\", \"confidence\": 0.6710182767624021}, {\"right\": \"泽兰\", \"left\": \"泽泻\", \"confidence\": 0.6714285714285714}]";
		
		JSONObject json = new JSONObject();
		JSONArray tt = new JSONArray();
		tt = JSON.parseArray(js);
		
		String[] cols = {"left","right","confidence"};
		
		a = new Object[tt.size()][cols.length];
		
		for (int j = 0; j < tt.size(); j++) {
//				System.out.println(eachcol.getString(rows.get(j)));
			json = JSONObject.parseObject(tt.get(j).toString());
			a[j][0] = json.get(cols[0]);
			a[j][1] = json.get(cols[1]);
			a[j][2] = json.get(cols[2]);
		}
		
		TableModel model = new DefaultTableModel(a,cols) {
			public Class getColumnClass(int column) {
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		tb = new JTable(model);
		TableRowSorter sorter = new TableRowSorter<TableModel>(model);
		tb.setRowSorter(sorter);

//		System.out.println(rows);
//		System.out.println(cols);
		
		Container con = getContentPane();
	
		getContentPane().add(new JScrollPane(tb),BorderLayout.CENTER);
	
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setTitle("关联度分析");
		setSize(10000,10000);
		setVisible(true);
		validate();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
//		HashSet<String> row =new HashSet<String>();
//		List<String> cols = new ArrayList<>(js.keySet());
		
//		System.out.println(js.get(0));
		
		
//		for (int i = 0; i < cols.size(); i++) {
//			Object j1 = js.get(cols.get(i));
//			String output = cols.get(i)+" -> "+j1.toString();
//			System.out.println(output);
//		}
		
		
//		List<String> rows = new ArrayList<>(js.getJSONObject(cols.get(0)).keySet());
		
//		System.out.println(cols);
		
//		a = new Object[rows.size()][cols.size()];
//		
//		for (int i = 0; i < cols.size(); i++) {
//			JSONObject eachcol = js.getJSONObject(cols.get(i));
//			for (int j = 0; j < rows.size(); j++) {
////				System.out.println(eachcol.getString(rows.get(j)));
//				a[j][i] = eachcol.getString(rows.get(j)); 
//			}
//		}
//		
//		tb = new JTable(a,cols.toArray());
//
//		System.out.println(rows);
//		System.out.println(cols);
//		
//		Container con = getContentPane();
//	
//		getContentPane().add(new JScrollPane(tb),BorderLayout.CENTER);
//		tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		setSize(10000,10000);
//		setVisible(true);
//		validate();
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}