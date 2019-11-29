package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Csv_try {
	

	public static void main(String[] args) {
		Object[] columnnames;
		CSVReader CSVFileReader = null;
		try {
			CSVFileReader = new CSVReader(new FileReader("/Users/zxjsama/temp900.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List myEntries = null;
		try {
			myEntries = CSVFileReader.readAll();
		} catch (IOException | CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		columnnames = (String[]) myEntries.get(0);
		DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size()-1); 
		int rowcount = tableModel.getRowCount();
		for (int x = 0; x<rowcount+1; x++)
		{
		    int columnnumber = 0;
		    // if x = 0 this is the first row...skip it... data used for columnnames
		    if (x>0)
		    {
		        for (String thiscellvalue : (String[])myEntries.get(x))
		        {
		            tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
		            columnnumber++;
		        }
		    }
		}
		System.out.println(tableModel);
		JTable MyJTable = new JTable(tableModel);
	}
}
