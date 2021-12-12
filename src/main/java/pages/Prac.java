package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Prac extends Base {


@FindBy (name="uid")
WebElement usernamebox;
@FindBy (name="password")
WebElement passwordbox;

@FindBy (name="btnLogin")
WebElement btnLogin;

@FindBy (xpath="//a[contains(text(),'Log out')]")
WebElement btnLogout;



public Prac() {
	
	PageFactory.initElements(driver, this);
	System.out.println("cons called");
}



	
	

	public String test1() {
		
		driver.get("http://demo.guru99.com/v4");
		//WebElement usernamebox=driver.findElement(By.name("uid"));
		//WebElement passwordbox=driver.findElement(By.name("password"));
		//WebElement btnLogin=driver.findElement(By.name("btnLogin"));
		usernamebox.sendKeys("mngr371386");
		passwordbox.sendKeys("YhyrYvu");
		btnLogin.submit();
		String abc=driver.getTitle();
		System.out.println(driver.getTitle());
		return abc;
		
	}
	
	public void test2() throws IOException {
		WebElement a= driver.findElement(By.xpath("//body/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]//child::li[1]"));
		
		Actions act=new Actions (driver);
		act.click(a).build().perform();
		
		
	}
	
	public void test3() {
WebElement a= driver.findElement(By.xpath("//body/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]//child::li[1]//child::li[1]"));
		
		Actions act=new Actions (driver);
		act.click(a).build().perform();
		
	}
	
	public void test4() {
		btnLogout.click();
		driver.switchTo().alert().accept();
		try {
			screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void screenshot() throws IOException {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:/Users/manoj/eclipse-workspace-new/TestPageFac/Screenshots/" + System.currentTimeMillis() + ".png"); 
		FileUtils.copyFile(screen, DestFile);
	}

public void tear() {
		driver.close();
		driver.quit();
	}
}
