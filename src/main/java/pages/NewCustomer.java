package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer extends Base {

	@FindBy(xpath = "//iframe[@id=\"google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0\"]")
	//iframe[@title=\"3rd party ad content\"]
	
	WebElement addiframelink;
	@FindBy(xpath = "//*[@id=\"dismiss-button\"]")
	WebElement Closeaddiframebutton;
	@FindBy(xpath = "//input[@type=\"text\"and @name=\"name\"]")
	WebElement inputnamebox;
	@FindBy(xpath = "//input[@type='radio' and @name='rad1']")
	WebElement gendercheckbox;
	@FindBy(xpath = "//input[@type='date' and @name='dob']")
	WebElement dobcalender;
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addrbox;
	@FindBy(xpath = "//input[@type='text' and @name='city']")
	WebElement citybox;
	
	@FindBy(xpath = "//input[@type='text' and @name='state']")
	WebElement statebox;
	@FindBy(xpath = "//input[@type='text' and @name='pinno']")
	WebElement pinbox;
	
	@FindBy(xpath = "//input[@type='text' and @name='telephoneno']")
	WebElement mobilebox;
	
	@FindBy(xpath = "//input[@type='text' and @name='emailid']")
	WebElement emailbox;
	@FindBy(xpath = "//input[@type='password' and @name='password']")
	WebElement passwordbox;
	@FindBy(xpath = "//input[@type='submit' and @name='sub']")
	WebElement submitbutton;
	
	@FindBy(xpath = "//p[@class=\"heading3\"]")
	WebElement aftersubmitheading;
	
	@FindBy(xpath = "//td[contains(text(),\"Customer Name\")]/following-sibling::td[1]")
	WebElement customername;
	
	
	
	
	
	public NewCustomer() {
		PageFactory.initElements(driver,this);
	}
	
	public String addNewCustomer(String name, String dob, String address, String city, String state, String pin, String mobile, String email, String password
) throws InterruptedException{
		Thread.sleep(2000);
	int size= driver.findElements(By.tagName("iframe")).size();
	System.out.println(size);
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		Closeaddiframebutton.click();
		driver.switchTo().defaultContent();
		inputnamebox.sendKeys(name);
		gendercheckbox.click();
		dobcalender.sendKeys(dob);
		addrbox.sendKeys(address);
		citybox.sendKeys(city);
		statebox.sendKeys(state);
		pinbox.sendKeys(pin);
		mobilebox.sendKeys(mobile);
		emailbox.sendKeys(email);
		passwordbox.sendKeys(password);
		Thread.sleep(4000);
		submitbutton.click();
		
	driver.switchTo().defaultContent();
	String check=aftersubmitheading.getText();
	String custName=customername.getText();
	
	return check;
	}
	
	
	
}
