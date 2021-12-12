

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Base;
import pages.Prac;

public class PracTest extends Base{
	
	Prac practice;
	
	public PracTest() {
		super();
		
	}

	@BeforeClass
	public void setup() {
		launch();
		practice=new Prac();
		
		
	}

	@Test
	public void t1() {
		String act=practice.test1();
		assertEquals(act, "Guru99 Bank Manager HomePage");
	}
	@Test
	public void t2() throws IOException {
		practice.test2();
	}
	@Test (enabled=false)
	public void t3() {
		practice.test3();
	}
	@Test
	public void t4() {
		practice.test4();
	}
	
	
	@AfterTest
	public void exit(){
		practice.tear();
	}


}
