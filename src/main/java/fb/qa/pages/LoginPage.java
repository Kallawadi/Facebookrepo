package fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fb.qa.base.TestBase;

public class LoginPage extends TestBase{

//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement LoginButton;
	
	@FindBy(linkText="Forgot password?")
	WebElement forgotpasswordlink;
	
	@FindBy(xpath="//a[@data-testid='open-registration-form-button']")
	WebElement createnewaccountlink;
	
	@FindBy(xpath="//img[@alt='Facebook']")
	WebElement Facebooklogo;
	
	@FindBy(linkText="Create a Page")
	WebElement createapagelink;
	
//initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//ACtions
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	public boolean validatefacebookimage() {
		return Facebooklogo.isDisplayed();
	}
	public HomePage Loginwithusernameandpassword(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		LoginButton.click();
		return new HomePage();
	}
	
	public boolean Forgotpasswordlink() {
		return forgotpasswordlink.isDisplayed();
	}
	
	public boolean Createapagelink() {
		return createapagelink.isDisplayed();
	}
	
	public boolean Createanewaccountpagelink() {
		return createnewaccountlink.isDisplayed();
	}
	
}
