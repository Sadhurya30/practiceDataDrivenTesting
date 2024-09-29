package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//step 1: get the java representation object of the physical file
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\commondata.properties");
		
		//step 2: using properties class load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);
	
		//step 3: get the value based on key
		System.out.println(pobj.getProperty("browser"));
		System.out.println(pobj.getProperty("url"));
		System.out.println(pobj.getProperty("username"));
		System.out.println(pobj.getProperty("password"));
		
		
	}

}
