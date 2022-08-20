package fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fb.qa.base.TestBase;

public class HomePage extends TestBase {

	//span[contains(text(),'Kapil Kapil')]
	
	@FindBy(xpath="//span[contains(text(),'Kapil Kapil')]")
	@CacheLookup
	WebElement validateusername;
	
	@FindBy(xpath="//span[contains(text(),'Groups')]")
	WebElement Groupslink;
	
	
	@FindBy(xpath="//span[contains(text(),'Marketplace')]")
	WebElement marketplacelink;
	
	
	@FindBy(xpath="//span[contains(text(),'Pages')]")
	WebElement pageslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatehomepagetitle() {
		return driver.getTitle();
	}
	
	public GroupsPage GroupsPagelink() {
		Groupslink.click();
		 return new GroupsPage();
	}
	
	public MarketPlacePage MarketPlacePagelink() {
		marketplacelink.click();
		 return new MarketPlacePage();
	}
	
	public PagesPage PagesPagelink() {
		pageslink.click();
		 return new PagesPage();
	}
	
	public boolean verifyusername() {
		return validateusername.isDisplayed();
	}
	
	
	
	
}
