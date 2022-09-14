package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Base;
import pages.HomePage;
import pages.ValidLoginPage;

public class HomePageTest extends Base {

	HomePage home;
	ValidLoginPage practice;
	String sheetName="validLogin"; 

	public HomePageTest() {
		super();
	}
	
	@DataProvider
	public Object[] dataexcel() throws IOException {
	Object[] 	extractedData=util.TestUtils.readFile(sheetName);
	return extractedData;
	}

	@BeforeClass
	public void setup() throws IOException {
		launch();
		practice = new ValidLoginPage();
		//home = practice.test1("mngr391197", "AsuqeqE");
	}

	@Test(dataProvider="dataexcel")
	public void homeTitleTest(String data1,String data2) throws IOException {
		home=practice.test1(data1,data2);
		
		String title = home.verifyHomePageTitle();
		assertEquals(title, "Guru99 Bank Manager HomePage");
	}
	@Test
	public void idTest() {
		assertEquals(home.verifyManagerId(),"Manger Id : mngr437157");
	}
	
	@AfterClass
	public void exit(){
		tear();
	}

}
