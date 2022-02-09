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

public class InvalidLoginPage extends Base {

	@FindBy(name = "uid")
	WebElement usernamebox;
	@FindBy(name = "password")
	WebElement passwordbox;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement btnLogout;

	public InvalidLoginPage() {

		PageFactory.initElements(driver, this);
		System.out.println("cons called");
	}

	public String test1(String data1, String data2) throws IOException {
		String abc = "";
		boolean alertisPresent;
		
		// WebElement usernamebox=driver.findElement(By.name("uid"));
		// WebElement passwordbox=driver.findElement(By.name("password"));
		// WebElement btnLogin=driver.findElement(By.name("btnLogin"));
		usernamebox.sendKeys(data1);
		passwordbox.sendKeys(data2);
		btnLogin.submit();
		WebDriverWait wait1 = new WebDriverWait(driver, 10 /* timeout in seconds */);
		try {

			wait1.until(ExpectedConditions.alertIsPresent());
			alertisPresent = true;
		} catch (NoAlertPresentException Ex) {
			alertisPresent = false;
		}
		if (alertisPresent = true) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("alert was present and accepted");
			abc = driver.getTitle();
			System.out.println(driver.getTitle());
			screenshot();
		} else {

			System.out.println("alert was not present");
			abc = driver.getTitle();
			System.out.println(driver.getTitle());
			screenshot();
		}

		return abc;

	}

	public void screenshot() throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File("D:/MAN/EWorkspace/TestPageFac/Screenshots/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(screen, DestFile);
	}

	public void tear() {
		driver.close();
		driver.quit();
	}
}
