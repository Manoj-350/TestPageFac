package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount extends Base {
	
	@FindBy(xpath = "//input[@name='cusid']")
	WebElement CustumerID;
	@FindBy(xpath = "//*[@id=\"dismiss-button\"]")
	WebElement Closeaddiframebutton;
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement NewAccount;
	
	@FindBy(xpath = "//select[@name='selaccount']")
	WebElement AccountType;
	
	@FindBy(xpath = "//input[@name='inideposit']")
	WebElement InitialDeposit;
	@FindBy(xpath = "//input[@name='button2'][@type='submit']")
	WebElement Submitbutton;
	
	public NewAccount() {
		PageFactory.initElements(driver,this);
	}
	
	public void NewAcc() {
		
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");

		
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Closeaddiframebutton));
		//Thread.sleep(2000);
		Closeaddiframebutton.click();
		driver.switchTo().defaultContent();
			
			System.out.println(driver.getTitle());
		CustumerID.sendKeys("123");
		
		
		
		Select select=new Select(AccountType);
		select.selectByValue("Current");
		
		InitialDeposit.sendKeys("123456");
		Submitbutton.click();
		
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
