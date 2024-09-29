package practicedatadriventesting;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateNewEmployeeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\commondata.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		//WebDriver driver =  new FirefoxDriver();
	//	driver.get("http://106.51.90.215/Build/Payroll_Management_System/login.php");
		
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url") ;
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		/*
		 * Scanner s = new Scanner(System.in); System.out.println("browser"); String
		 * browser = s.next(); //System.out.println(browser);
		 */	
		
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver =  new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		 driver.close();
		
		/*
		 * driver.findElement(By.id("username")).sendKeys("admin");
		 * driver.findElement(By.id("password")).sendKeys("admin123");
		 * 
		 * driver.findElement(By.xpath("//button[text()='Login']")).click();
		 * 
		 * //
		 * driver.findElement(By.className("nav-item nav-attendance active")).click();
		 * driver.findElement(By.xpath("//a[contains(@class,\"nav-allowances\")]")).
		 * click(); driver.quit();
		 */
		//multi line comment select the lines you want to comment and press ctrl+shift +?
	}

}
