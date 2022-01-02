package pages;




import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidLoginPage extends Base {


@FindBy (name="uid")
WebElement usernamebox;
@FindBy (name="password")
WebElement passwordbox;

@FindBy (name="btnLogin")
WebElement btnLogin;

@FindBy (xpath="//a[contains(text(),'Log out')]")
WebElement btnLogout;



public ValidLoginPage() {
	
	PageFactory.initElements(driver, this);
	System.out.println("cons called");
}



	
	

	public String test1(String data1,String data2) throws IOException {
		String abc="";
	
		driver.get("http://demo.guru99.com/V1/");
		//WebElement usernamebox=driver.findElement(By.name("uid"));
		//WebElement passwordbox=driver.findElement(By.name("password"));
		//WebElement btnLogin=driver.findElement(By.name("btnLogin"));
		usernamebox.sendKeys(data1);
		passwordbox.sendKeys(data2);
		btnLogin.submit();
		 
                          abc=driver.getTitle();
                 		System.out.println(driver.getTitle());
                 		screenshot();
             
		return abc;
		
	}
	
	public void test2() throws IOException {
		WebElement a= driver.findElement(By.xpath("//a[contains(text(),'Selenium') and @class=\"dropdown-toggle\"]"));
		WebElement b= driver.findElement(By.xpath("//a[contains(text(),'Flash Movie Demo') ]//following::li[3]"));
		
		Actions act=new Actions (driver);
		act.click(a).build().perform();
		
		screenshot();
	}
	
	public void test3() {
WebElement a= driver.findElement(By.xpath("//body/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]//child::li[1]//child::li[1]"));
		
		Actions act=new Actions (driver);
		act.click(a).build().perform();
		
	}
	
	public void test4() throws IOException {
		btnLogout.click();
		
		driver.switchTo().alert().accept();
		screenshot();
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

