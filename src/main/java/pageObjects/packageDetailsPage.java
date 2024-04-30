package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class packageDetailsPage {
	WebDriver driver;
	
	public packageDetailsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//@FindBy(css="button[_ngcontent-ng-c3443763774]")
//	@FindBy(xpath = "/html/body/app-root/app-package-details/div/div[3]/button")
	@FindBy(css = "body > app-root > app-package-details > div > div.text1 > button")
	private WebElement reserveBtn;
	
	public WebElement reserveBtn() {
		return reserveBtn;
	}
	


}
