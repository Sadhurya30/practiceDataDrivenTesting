package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//Step 1: get the Excel path location and java object of the physical Excel file
		    FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
		
		//step 2: open workbook in read mode
		  Workbook wb = WorkbookFactory.create(fis);
		   
		//step 3: get the control of the org sheet
		 Sheet sh =  wb.getSheet("org");  
		 
		//step 4: get the control of the "1st" row
		   Row row =    sh.getRow(1);
		   
		//Step 5: get the control of the 2nd cell and read the string data
		  // String data = row.getCell(3).getStringCellValue();
		  // int data = (int) row.getCell(3).getNumericCellValue();
		   
		  // String data = row.getCell(3).getStringCellValue();//put ' in the excel before numeric value,for eg value 200
		   //if you dont give apostrophe
		  // else you will get 200.0
		   String data = row.getCell(3).toString(); 
		   
		  // String data = cel.getStringCellValue();
		   System.out.println(data);
		   
		//step 6: close the workbook
		   wb.close();
		   //if filenotfoundexception throws, then change the location of the xlsx file
	}

}
