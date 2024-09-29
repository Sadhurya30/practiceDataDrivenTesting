package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//if excel is open filenotfoundexception will throw
		//so we have to close the excel before running the program
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
		
		 Workbook wb = WorkbookFactory.create(fis);
		   
		 Sheet sh =  wb.getSheet("org");  
		 
		 Row row = sh.getRow(1);
		 Cell cel =  row.createCell(4);
		 cel.setCellType(CellType.STRING);
		 cel.setCellValue("FAIL");
		 
		 //after setting the cell value we have to again load the file via fileoutputstream
		 //so that the changes[data will be written in the excel file] will be made in the excel file
		 
		 //FileOutputStream fos = new FileOutputStream("‪C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
		 FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Admin\\\\Desktop\\\\data\\\\TestScriptData.xlsx");
		 wb.write(fos);
		 wb.close();
		 System.err.println("=====Executed====");
		 
		 
	}

}
