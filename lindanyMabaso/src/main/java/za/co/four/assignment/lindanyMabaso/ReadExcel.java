package za.co.four.assignment.lindanyMabaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ReadExcel {
	

//	public static void main(String [] args) throws IOException{
//		FileInputStream fis = new FileInputStream("data.xlsx");
//		
//		//we create an XSSF Workbook object for our XLSX Excel File
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		//we get first sheet
//		XSSFSheet sheet = workbook.getSheetAt(2);
//		
//		//we iterate an rows
//		Iterator<Row> rowIt = sheet.iterator();
//		
//		while(rowIt.hasNext()) {
//			Row row = rowIt.next();
//			
//			Iterator<Cell> cellIterator = row.cellIterator();
//			String routeID="", origin="", dest="", delay="";
//			int index=0;
//			while(cellIterator.hasNext()) {
//				 Cell cell = cellIterator.next();
//				 switch (index) {
//					 case 0:
//						 routeID = cell.toString();
//						 break;
//					 case 1:
//						 origin = cell.toString();
//						 break;
//					 case 2:
//						 dest = cell.toString();
//						 break;
//					 case 3:
//						 delay = cell.toString();
//						 break;
//					  default:
//						  delay =cell.toString();
//						  break;
//				 }
//				 index++;
//			
//			}
//			System.out.println(routeID+"  "+origin+" "+dest+" "+delay);
//		}
//		workbook.close();
//		fis.close();
//	}
	
	public ArrayList<String> getPlanetList(int workbookNo) throws IOException{
		FileInputStream fis = new FileInputStream("data.xlsx");
		ArrayList<String> planetList =new ArrayList<String>();//Creating arraylist    

		//we create an XSSF Workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//we get first sheet
		XSSFSheet sheet = workbook.getSheetAt(workbookNo);
		
		//we iterate an rows
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			String Node="", Planet="";
			int index=0;
			while(cellIterator.hasNext()) {
				 Cell cell = cellIterator.next();
				 switch (index) {
					 case 0:
						 Node = cell.toString();
						 break;
					 case 1:
						 Planet = cell.toString();
						 break;
					 default:
						  break;
				 }
				 index++;			
			}
			planetList.add(Node+"  "+Planet);
			System.out.println(Node+"  "+Planet);
		}
		workbook.close();
		fis.close();
		return planetList;
	}
	
	public ArrayList<String> getRoutesList(int workbookNo) throws IOException{
		FileInputStream fis = new FileInputStream("data.xlsx");
		ArrayList<String> planetList =new ArrayList<String>();//Creating arraylist    

		//we create an XSSF Workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//we get first sheet
		XSSFSheet sheet = workbook.getSheetAt(workbookNo);
		
		//we iterate an rows
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			String routeID="", origin="", dest="", delay="";
			int index=0;
			while(cellIterator.hasNext()) {
				 Cell cell = cellIterator.next();
				 switch (index) {
					 case 0:
						 routeID = cell.toString();
						 break;
					 case 1:
						 origin = cell.toString();
						 break;
					 case 2:
						 dest = cell.toString();
						 break;
					 case 3:
						 delay = cell.toString();
						 break;
					  default:
						  delay =cell.toString();
						  break;
				 }
				 index++;			
			}
			planetList.add(routeID+"  "+origin+" "+dest+" "+delay);
			System.out.println(routeID+"  "+origin+" "+dest+" "+delay);
		}
		workbook.close();
		fis.close();
		return planetList;
	}
	
	
	public ArrayList<String> getTrafficList(int workbookNo) throws IOException{
		FileInputStream fis = new FileInputStream("data.xlsx");
		ArrayList<String> planetList =new ArrayList<String>();//Creating arraylist    

		//we create an XSSF Workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//we get first sheet
		XSSFSheet sheet = workbook.getSheetAt(workbookNo);
		
		//we iterate an rows
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			String routeID="", origin="", dest="", traffic="";
			int index=0;
			while(cellIterator.hasNext()) {
				 Cell cell = cellIterator.next();
				 switch (index) {
					 case 0:
						 routeID = cell.toString();
						 break;
					 case 1:
						 origin = cell.toString();
						 break;
					 case 2:
						 dest = cell.toString();
						 break;
					 case 3:
						 traffic = cell.toString();
						 break;
					  default:
						  traffic =cell.toString();
						  break;
				 }
				 index++;			
			}
			planetList.add(routeID+"  "+origin+" "+dest+" "+traffic);
			System.out.println(routeID+"  "+origin+" "+dest+" "+traffic);
		}
		workbook.close();
		fis.close();
		return planetList;
	}
	
	
}
