package testCases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Base;
import pages.HomePage;
import pages.ValidLoginPage;

public class ValidLoginPageTest extends Base{
	
	ValidLoginPage practice;
	String sheetName="validLogin";
	public ValidLoginPageTest() {
		super();
		
	}
	
	@DataProvider
	public Object[] dataexcel() throws IOException {
	Object[] 	extractedData=util.TestUtils.readFile(sheetName);
	return extractedData;
	}

	@BeforeClass
	
	public void setup() {
		launch();
		practice=new ValidLoginPage();
		
		
	}

	@Test(dataProvider="dataexcel" , priority = 1)
	public void t1(String data1,String data2) throws IOException {
		practice.test1(data1,data2);
		
		assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
		
		
	}
	
	@Test(dependsOnMethods = {"t1"})
	public void t2() throws IOException {
		practice.test2();
	}
	@Test (enabled=false)
	public void t3() {
		practice.test3();
	}
	@Test(dependsOnMethods = {"t1"})
	public void t4() throws IOException {
		practice.test4();
	}
	
	
	@AfterClass
	public void exit(){
		tear();
	}


}
