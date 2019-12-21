package haru.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Relation extends JFrame{
	
	JTable tb;
	Object a[][],b[];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relation window = new Relation();
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
	public Relation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String js = DataImport.post_response4;
		
		System.out.println(js);
//		String js = "[{"right": "仙鹤草", "left": "鸡血藤", "confidence": 0.6329305135951662}, {"right": "仙鹤草", "left": "生薏苡仁", "confidence": 0.8095238095238095}, {"right": "仙鹤草", "left": "党参", "confidence": 0.8126888217522659}, {"right": "仙鹤草", "left": "焦白术", "confidence": 0.7900302114803626}, {"right": "葎草", "left": "银柴胡", "confidence": 0.75}, {"right": "麻黄根", "left": "麻黄", "confidence": 0.8571428571428571}, {"right": "生地黄", "left": "丹皮", "confidence": 0.6172839506172839}, {"right": "怀牛膝", "left": "熟地黄", "confidence": 0.7142857142857143}, {"right": "怀牛膝", "left": "千年健", "confidence": 0.7058823529411765}, {"right": "紫草", "left": "水牛角片", "confidence": 0.8157894736842105}, {"right": "紫草", "left": "丹皮", "confidence": 0.6470588235294118}, {"right": "紫草", "left": "狗舌草", "confidence": 0.6136363636363636}, {"right": "水红花子", "left": "红花", "confidence": 0.9827586206896551}, {"right": "半枝莲", "left": "蛇舌草", "confidence": 0.6642335766423357}, {"right": "银柴胡", "left": "葎草", "confidence": 0.75}, {"right": "泽泻", "left": "泽兰", "confidence": 0.6714285714285714}, {"right": "泽兰", "left": "泽泻", "confidence": 0.6714285714285714}, {"right": "桑椹", "left": "生何首乌", "confidence": 0.7894736842105263}, {"right": "赤石脂", "left": "禹余粮", "confidence": 0.8181818181818182}, {"right": "娑罗子", "left": "佛手", "confidence": 0.75}]";
		
		JSONObject json = new JSONObject();
		JSONArray tt = new JSONArray();
		tt = JSON.parseArray(js);
		
		String[] cols = {"left","right","confidence"};
		
		a = new Object[tt.size()][cols.length];
		
		for (int j = 0; j < tt.size(); j++) {
//					System.out.println(eachcol.getString(rows.get(j)));
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

//			System.out.println(rows);
//			System.out.println(cols);
		
		Container con = getContentPane();
	
		getContentPane().add(new JScrollPane(tb),BorderLayout.CENTER);
	
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setTitle("关联度分析");
		setSize(10000,10000);
		setVisible(true);
		validate();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

}
