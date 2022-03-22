package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Base {
	public static	WebDriver driver;
	public static Properties prop;
	@FindBy (name="uid")
	WebElement usernamebox;
	@FindBy (name="password")
	WebElement passwordbox;

	@FindBy (name="btnLogin")
	WebElement btnLogin;

	@FindBy (xpath="//a[contains(text(),'Log out')]")
	WebElement btnLogout;
	
	public Base (){
		PageFactory.initElements(driver, this);
		try{
			prop = new Properties();
			FileInputStream ip= new FileInputStream("D:/MAN/EWorkspace/TestPageFac/src/main/java/Config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
			}
	}
	
	public void launch() {
		System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	

	
	
	public void screenshot() throws IOException {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File("D:/MAN/EWorkspace/TestPageFac/Screenshots/" + System.currentTimeMillis() + ".png"); 
		FileUtils.copyFile(screen, DestFile);
	}
	

	
	public void tear() {
		driver.close();
		driver.quit();
	}
}
