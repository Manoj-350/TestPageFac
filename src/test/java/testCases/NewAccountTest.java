package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Base;
import pages.HomePage;
import pages.NewAccount;
import pages.NewCustomer;
import pages.ValidLoginPage;

public class NewAccountTest extends Base{
	ValidLoginPage practice;
	HomePage home;
	NewAccount newaccount;
	String sheetName="addnewcustomer";
	String sheetName2="validLogin";
	public NewAccountTest() {
		super();
	}
	
	@DataProvider
	public Object[] dataexcel() throws IOException {
	Object[] 	extractedData=util.TestUtils.readFile(sheetName);
	return extractedData;
	}
	@DataProvider
	public Object[] dataexcelLogin() throws IOException {
	Object[] 	extractedData=util.TestUtils.readFile(sheetName2);
	return extractedData;
	}
	
	
@BeforeMethod
public void setup() throws IOException {
	launch();
	practice=new ValidLoginPage();
	home=practice.test1(prop.getProperty("validUsername"), prop.getProperty("validPassword"));
	newaccount=home.NavigateNewAccount();
	}
@Test
public void NewAccTest() {
	newaccount.NewAcc();
}

@AfterMethod
public void exit(){
	tear();
}


}
