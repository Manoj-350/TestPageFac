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

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() throws IOException {
		launch();
		practice = new ValidLoginPage();
		home = practice.test1("mngr379588", "qyzEren");
	}

	@Test
	public void homeTitleTest() {
		String title = home.verifyHomePageTitle();
		assertEquals(title, "Guru99 Bank Manager HomePage");
	}
	@Test
	public void idTest() {
		assertEquals(home.verifyManagerId(),"Manger Id : mngr379588");
	}
	
	@AfterClass
	public void exit(){
		tear();
	}

}
