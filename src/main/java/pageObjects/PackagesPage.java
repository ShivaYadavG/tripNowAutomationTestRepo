package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackagesPage {
	
	WebDriver driver;
	public PackagesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/app-package/div/section/div[2]/div[1]")
	private WebElement packageCard;
	
	public WebElement packageCard() {
		return packageCard;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-package/div/section/input")
	private WebElement packageSearchBox;
	
	public WebElement packageSearchBox() {
		return packageSearchBox;
	}
	
	
}
