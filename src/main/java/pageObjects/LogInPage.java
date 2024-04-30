package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage{
	WebDriver driver;
	public LogInPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/form/input[1]")
	private WebElement emailBox;
	
	public WebElement emailBox() {
		return emailBox;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/form/input[2]")
	private WebElement passwordBox;
	
	public WebElement passwordBox() {
		return passwordBox;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/form/button")
	private WebElement SignIn;
	
	public WebElement SignIn() {
		return SignIn;
	}

}
