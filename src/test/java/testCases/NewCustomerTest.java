package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Base;
import pages.HomePage;
import pages.NewCustomer;
import pages.ValidLoginPage;

public class NewCustomerTest extends Base{
	
	ValidLoginPage practice;
	HomePage home;
	NewCustomer newcustomer;
	String sheetName="addnewcustomer";
	String sheetName2="validLogin";
	public NewCustomerTest() {
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
	newcustomer=home.NavigateaddNewCustomer();
	}
	

@Test ( dataProvider="dataexcel")
public void addNewCustomerTest(String name, String dob, String address, String city, String state, String pin, String mobile, String email, String password
) throws InterruptedException {
	String check=newcustomer.addNewCustomer(name, dob, address, city, state, pin, mobile, email, password
);
	assertEquals(check,"Customer Registered Successfully!!!", "title not matched");
	
}


@AfterMethod
public void exit(){
	tear();
}

}
