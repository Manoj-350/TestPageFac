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
import pages.InvalidLoginPage;

public class InvalidLoginPageTest extends Base{
	
	InvalidLoginPage practice;
	String sheetName="invalidLogin";
	public InvalidLoginPageTest() {
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
		practice=new InvalidLoginPage();
		
	}

	@Test(dataProvider="dataexcel" )
	public void t1(String data1,String data2) throws IOException {
		String act=practice.test1(data1,data2);
		
		System.out.println(data1+data2);
		
		assertEquals(act, "Guru99 Bank Home Page");
		
	}
	
	@AfterClass
	public void exit(){
		tear();
	}


}
