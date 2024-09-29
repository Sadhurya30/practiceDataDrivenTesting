package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\commondata1.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		//WebDriver driver =  new FirefoxDriver();
	   //	driver.get("http://106.51.90.215/Build/Payroll_Management_System/login.php");
		
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url") ;
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		//generate the random number
		Random random = new Random();
		int randomInt = random.nextInt();
		
		//Read testcriptdata from excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\TestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		
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
		
		
		//step1: login to application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//step 2:  navigate to organisations module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 3: click on create organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 4: enter all the details and create new organisation
		driver.findElement(By.xpath("//input[@name=\'accountname\']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//step 5 :logout
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.xpath("a[text()='Sign Out")).click();
		
		//driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);		

	}

}
