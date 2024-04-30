package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetails {
	WebDriver driver;

	public PaymentDetails(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[2]/input[1]")
	private WebElement firstName;

	public WebElement firstName() {
		return firstName;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[2]/input[2]")
	private WebElement lastName;

	public WebElement lastName() {
		return lastName;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/input")
	private WebElement emailBoxPayment;

	public WebElement emailBoxPayment() {
		return emailBoxPayment;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[7]/input[1]")
	private WebElement phoneNumber;

	public WebElement phoneNumber() {
		return phoneNumber;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[7]/input[2]")
	private WebElement age;

	public WebElement age() {
		return age;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[9]/input")
	private WebElement reciveMessagCheckBox;

	public WebElement reciveMessagCheckBox() {
		return reciveMessagCheckBox;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[11]/button")
	private WebElement nextBtn;

	public WebElement nextBtn() {
		return nextBtn;
	}

	@FindBy(xpath = "/html/body/app-root/app-booking/div[2]/div[1]/div[3]/form/div[10]/input")
	private WebElement promoCodeBox;

	public WebElement promoCodeBox() {
		return promoCodeBox;
	}

}
