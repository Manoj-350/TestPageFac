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
import org.testng.annotations.Test;

public class ValidLoginPage extends Base {
	

	public HomePage test1(String data1,String data2) throws IOException {
		String abc="";
	
		
		//WebElement usernamebox=driver.findElement(By.name("uid"));
		//WebElement passwordbox=driver.findElement(By.name("password"));
		//WebElement btnLogin=driver.findElement(By.name("btnLogin"));
		usernamebox.sendKeys(data1);
		passwordbox.sendKeys(data2);
		btnLogin.submit();
		 
                          abc=driver.getTitle();
                 		System.out.println(driver.getTitle());
                 		screenshot();
             
		return new HomePage();
		
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
	
	


}

