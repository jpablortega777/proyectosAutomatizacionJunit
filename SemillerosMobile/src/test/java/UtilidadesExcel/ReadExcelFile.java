package UtilidadesExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	//CONSTRUCTOR VACIO 
		public ReadExcelFile()
		{
		
		}
		//METODO DE LECTURA DE ARCHIVO EXCEL
		public void ReadExcel(String filepath,String sheetName) throws IOException
		{
			
			try {
				File file= new File(filepath);
				FileInputStream inputStream;
				inputStream = new FileInputStream(file);
				XSSFWorkbook newWorkbook= new XSSFWorkbook(inputStream);
				XSSFSheet newSheet= newWorkbook.getSheet(sheetName);
				int rowCount= newSheet.getLastRowNum() + newSheet.getFirstRowNum();
				for (int i=0; i<rowCount; i++)
				{
					XSSFRow row= newSheet.getRow(i);
					for (int j=0; j<row.getLastCellNum(); j++)
					{
						
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		//METODO DE TRAER LOS VALORES DE LAS CELDAS DEL ARCHIVO EXCEL 
		public String getCellValue(String filepath,String sheetName,int rowName,int cellNumber) throws IOException
		{
			File file= new File(filepath);
			FileInputStream inputStream = new FileInputStream(file) ;
			XSSFWorkbook newWorkbook= new XSSFWorkbook(inputStream);
			XSSFSheet newSheet= newWorkbook.getSheet(sheetName);
			XSSFRow row= newSheet.getRow(rowName);
			XSSFCell cell= row.getCell(cellNumber);
			return cell.getStringCellValue();
			
		}

}
