package Demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		//readCSV();
		readXLS();
	}

	public static void readCSV() {
		String filename = "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\UserAccounts.csv";
		List <String[]> records = Utilities.CSV.get(filename);
		//iterating trough the list
		for (String [] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String filename="C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\UserLogin.xls";
		String [][]data = Utilities.Excel.get(filename);
		for(String[]record : data) {
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
