package generalUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteExcel 
{
	/*public static void main(String[] args) {
		
		ReadWriteExcel obj = new ReadWriteExcel();
		String email = obj.readExcel("LoginCredential",1,0);
		System.out.println("Email : "+email);
		String password = obj.readExcel("LoginCredential", 1, 1);
		System.out.println("Password : "+password);	
	}*/
	public String readExcel(String sheetName , int rNum , int cNum)
	{
		String data = "";
	try {
			FileInputStream fis = new FileInputStream(".\\data\\LoginCredential.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("Sheet1");
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			data = c.getStringCellValue();	
			}
		
		catch(Exception e)
			{
			try
			{
			FileInputStream fis = new FileInputStream(".\\data\\LoginCredential.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("Sheet1");
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			int numericValue = (int) c.getNumericCellValue();
			String str = Integer.toString(numericValue);
			data = str;
			}
			catch(Exception f)
			{
			f.printStackTrace();
			}
			}
		
		return data;		
	}

}
