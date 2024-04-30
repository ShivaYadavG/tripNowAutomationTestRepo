package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;

	public ContactUsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/button")
	private WebElement contactUsBtn;

	public WebElement contactUsBtn() {
		return contactUsBtn;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/input[1]")
	private WebElement contactUsNameBox;

	public WebElement contactUsNameBox() {
		return contactUsNameBox;
	}

	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/input[2]")
	private WebElement contactUsEmailBox;

	public WebElement contactUsEmailBox() {
		return contactUsEmailBox;
	}

	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/input[3]")
	private WebElement contactUsPhoneNumber;

	public WebElement contactUsPhoneNumber() {
		return contactUsPhoneNumber;
	}

	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/textarea")
	private WebElement contactUsQueryBox;

	public WebElement contactUsQueryBox() {
		return contactUsQueryBox;
	}

	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/div/button[1]")
	private WebElement contactUsSubmitBtn;

	public WebElement contactUsSubmitBtn() {
		return contactUsSubmitBtn;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-home/app-contactus/div/form/div/button[2]")
	private WebElement contactUsCloseBtn;

	public WebElement contactUsCloseBtn() {
		return contactUsCloseBtn;
	}

}
