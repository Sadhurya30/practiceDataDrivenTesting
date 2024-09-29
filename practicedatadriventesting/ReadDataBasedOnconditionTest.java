package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnconditionTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		 String data="";
		 String data1="";
		 String data2="";
		 String data3 ="";
		 boolean flag = false;
		 
	 
		 String  expectedTestid = "tc_02";
		 FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
			
		 Workbook wb = WorkbookFactory.create(fis);
		   
		 Sheet sh =  wb.getSheet("org");  
		 int rowcount = sh.getLastRowNum();
		    for(int i=0;i<=rowcount;i++)
		    {
		    	try {
		          data = sh.getRow(i).getCell(0).toString();
		          if(data.equals(expectedTestid)) {
		        	  flag = true;
		        	  data1 = sh.getRow(i).getCell(1).toString();
		        	  data2 = sh.getRow(i).getCell(2).toString();
		        	  data3= sh.getRow(i).getCell(3).toString();
		        	  
		          }
		    	}
		    	catch (Exception e) {}

		    }
		    
		    if(flag==true)
		    {
		    	 System.out.println(data1);
				 System.out.println(data2);
				 System.out.println(data3);
		      	
		    }
		    else {
		        System.out.println(expectedTestid + " data is not available"); 
		 
		    }
            wb.close();
	}

}
//Result
/*
createorgtest
Instagram
Social
*/
