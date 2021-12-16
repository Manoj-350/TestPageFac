

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Base;
import pages.Prac;

public class PracTest extends Base{
	
	Prac practice;
	
	public PracTest() {
		super();
		
	}
	
	@DataProvider
	public Object[] dataexcel() throws IOException {
	Object[] 	extractedData=util.TestUtils.readFile();
	return extractedData;
	}

	@BeforeClass
	
	public void setup() {
		launch();
		practice=new Prac();
		
		
	}

	@Test(dataProvider="dataexcel")
	public void t1(String data1,String data2) throws IOException {
		String act=practice.test1(data1,data2);
		
		System.out.println(data1+data2);
		
		assertEquals(act, "Guru99 Bank Manager HomePage");
		
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
	
	
	@AfterTest
	public void exit(){
		practice.tear();
	}


}
