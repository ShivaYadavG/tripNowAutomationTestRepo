package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;	
	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Packages")
	private WebElement packages;
	
	public WebElement packages() {
		return packages;
	}
	
	@FindBy(linkText="Exclusive")
	private WebElement Exclusive;
	
	public WebElement Exclusive() {
		return Exclusive;
	}
	
	@FindBy(linkText="Review")
	private WebElement Review;
	
	public WebElement Review() {
		return Review;
	}

}
