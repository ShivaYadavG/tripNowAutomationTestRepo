package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	WebDriver driver;	
	public LogOutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/app-header/header/div[2]/i[2]")
	private WebElement logInLogo;
	
	public WebElement logInLogo() {
		return logInLogo;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-header/div/form/input")
	private WebElement logOutButton;
	
	public WebElement logOutButton() {
		return logOutButton;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-header/div/i")
	private WebElement logInFormCloseBtn;
	
	public WebElement logInFormCloseBtn() {
		return logInFormCloseBtn;
	}
	

}
