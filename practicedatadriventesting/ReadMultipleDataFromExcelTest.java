package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		
	    FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
	
	    //create means open in workbook
	    Workbook wb = WorkbookFactory.create(fis);
	   
	    Sheet sh =  wb.getSheet("Sheet1");  
	    
	  //  Row row = sh.getRow(1);
	    int rowcount = sh.getLastRowNum();// to get the count of the last row
	    //even if we increase/decrease the count of the row this method will be helpful
	    for(int i=1;i<=rowcount;i++)
	    {
	      Row row = sh.getRow(i);
	      String column1Data = row.getCell(0).toString();
	      String column2Data = row.getCell(1).toString();
	      System.out.println(column1Data + "\t" + column2Data);
	   // System.out.println(column2Data);
	    

	}
	    wb.close();
	    
	    //row starts from 1 because we are ignoring the A,B,C,D  value in the top
	    //column starts from 1 because we are ignoring the serial number value in the left
	    //cell starts from 0

}
}
