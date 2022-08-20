package fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fb.qa.base.TestBase;
import fb.qa.pages.GroupsPage;
import fb.qa.pages.HomePage;
import fb.qa.pages.LoginPage;
import fb.qa.pages.MarketPlacePage;
import fb.qa.pages.PagesPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	GroupsPage groupspage;
	MarketPlacePage marketplacepage;
	PagesPage pagespage;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();	
		 loginpage = new LoginPage();
		 groupspage = new GroupsPage();
		 marketplacepage=new MarketPlacePage();
		 pagespage = new PagesPage();
		 homepage=loginpage.Loginwithusernameandpassword(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void Homepagetitletest() {
		String title=homepage.validatehomepagetitle();
		Assert.assertEquals(title, "Facebook");
		System.out.println(title);
	}
	@Test(priority=2)
	public void Verifyusernametest() {
		Assert.assertTrue(homepage.verifyusername());
	}
	@Test(priority=3)
	public void Groupslinktest() {
	groupspage=homepage.GroupsPagelink();
	}
	@Test(priority=4)
	public void MarketPlacePagelinktest() {
	marketplacepage=homepage.MarketPlacePagelink();
	}
	@Test(priority=5)
	public void PagesPagelink() {
		pagespage=homepage.PagesPagelink();
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
