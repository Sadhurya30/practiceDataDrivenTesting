package practicedatadriventesting;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		//step1 : parse json physical file into java objcet using json parse class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\Desktop\\dataJSON\\appCommonData.json"));
		
		//step 2 : convert java object into json object using downcasting 
		JSONObject map = (JSONObject)obj;
		//Step3 get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		
		
	}

}
