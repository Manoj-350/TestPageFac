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

public class NewTab extends Base {
	
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
	
	public NewTab() {
		PageFactory.initElements(driver,this);
	}
	
	public void NewTabmethod() {
		int size= driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");

		
		System.out.println(driver.getTitle());
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Closeaddiframebutton));
		//Thread.sleep(2000);
		Closeaddiframebutton.click();
		driver.switchTo().defaultContent();
			
			
		CustumerID.sendKeys("123");
		driver.switchTo().defaultContent();
		
		String parent=driver.getWindowHandle();
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		NewAccount.sendKeys(selectLinkOpeninNewTab);
		
		NewAccount.sendKeys(selectLinkOpeninNewTab);
		
		NewAccount.sendKeys(selectLinkOpeninNewTab);
		
		NewAccount.sendKeys(selectLinkOpeninNewTab);
		
		Set<String> s1=driver.getWindowHandles();
		
		Iterator<String> ss1=s1.iterator();
		
		while (ss1.hasNext()) {
			String childWindow=ss1.next();
			if (!(parent.equals(childWindow))) {
				driver.switchTo().window(childWindow);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String ChildTitle=driver.getTitle();
				System.out.println(ChildTitle);
				driver.close();
			}
			
			driver.switchTo().window(parent);
			
			
			
			
		}
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
