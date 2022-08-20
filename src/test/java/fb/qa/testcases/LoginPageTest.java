//author-kapil


package fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fb.qa.base.TestBase;
import fb.qa.pages.HomePage;
import fb.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();	
		 loginpage = new LoginPage();
	}
	@Test(priority=1)
	public void Loginpagetitletest() {
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Facebook - log in or sign up");	
	}
	
	@Test(priority=2)
	public void fblogoimagetest() {
		boolean flag=loginpage.validatefacebookimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void forgotpasswordlinktest() {
		boolean link=loginpage.Forgotpasswordlink();
		Assert.assertTrue(link);
	}
	@Test(priority=4)
	public void Createapagelinktest() {
		boolean link=loginpage.Createapagelink();
		Assert.assertTrue(link);
	}
	@Test(priority=5)
	public void Createnewaccountlinktest() {
		boolean link=loginpage.Createanewaccountpagelink();
		Assert.assertTrue(link);
	}
	
	
	@Test(priority=6)
	public void LoginwithusernameandpasswordTest() {
		homepage=loginpage.Loginwithusernameandpassword(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
}
