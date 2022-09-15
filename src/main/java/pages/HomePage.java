package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base  {

	@FindBy(xpath = "//tr[@class=\"heading3\"]/td")
	WebElement managerId;
	@FindBy(xpath = "//li/a[contains(text(),'New Customer')]")
	WebElement NewCustomerlink;
	
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement NewAccount;
	
	
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
public  String verifyHomePageTitle() {
	String Hometitle =driver.getTitle();
	return Hometitle;
}

public String verifyManagerId() {
	String id=managerId.getText();
	return id;
}



public NewCustomer NavigateaddNewCustomer () {
	
	NewCustomerlink.click();
	
	return new NewCustomer() ;
	
}
public NewAccount NavigateNewAccount () {
	
	NewAccount.click();
	
	
	return new NewAccount() ;
	
}

public NewTab NavigateNewTab () {
	
	NewAccount.click();
	
	
	return new NewTab() ;
	
}



}
