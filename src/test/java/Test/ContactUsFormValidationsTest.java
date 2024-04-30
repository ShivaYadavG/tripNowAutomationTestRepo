package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactUsPage;
import pageObjects.LandingPage;
import pageObjects.PackagesPage;
import resources.Base;

public class ContactUsFormValidationsTest extends Base {
	public WebDriver driver;

	@Test(priority = 1)
	public void ContactUsFormNameValidation() throws InterruptedException, EncryptedDocumentException, IOException {
		ContactUsPage ContactUsPage = new ContactUsPage(driver);

		Thread.sleep(2000);
		ContactUsPage.contactUsBtn().click();
		log.debug("Clikced on the contact us button");
		
		ContactUsPage.contactUsNameBox().sendKeys("abcd1");
		log.debug("Entered invalid name in contact us name box");
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void ContactUsFormEmailValidation() throws InterruptedException, EncryptedDocumentException, IOException {
		ContactUsPage ContactUsPage = new ContactUsPage(driver);

		Thread.sleep(2000);
		ContactUsPage.contactUsBtn().click();
		log.debug("Clikced on the contact us button");

		ContactUsPage.contactUsEmailBox().sendKeys("abcd1");
		Thread.sleep(2000);
		log.debug("Entered invalid name in contact us name box");
	}

	@Test(priority = 3)
	public void ContactUsFormPhoneNumberValidation()
			throws InterruptedException, EncryptedDocumentException, IOException {
		ContactUsPage ContactUsPage = new ContactUsPage(driver);

		Thread.sleep(2000);
		ContactUsPage.contactUsBtn().click();
		log.debug("Clikced on the contact us button");

		ContactUsPage.contactUsPhoneNumber().sendKeys("abcd1");
		Thread.sleep(2000);
		log.debug("Entered invalid name in contact us name box");
	}

	@Test(priority = 4)
	public void ContactUsFormCloseValidation()
			throws InterruptedException, EncryptedDocumentException, IOException {
		ContactUsPage ContactUsPage = new ContactUsPage(driver);

		Thread.sleep(2000);
		ContactUsPage.contactUsBtn().click();
		log.debug("Clikced on the contact us button");

		ContactUsPage.contactUsCloseBtn();
		Thread.sleep(2000);
		log.debug("Clicked on the contact us form close button");
	}

	
	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(ContactUsFormValidationsTest.class.getName());
		// opening the website

		driver = initializeBrowser();
		log.debug("Broswer initialized");

		// Passing Website URL
		driver.get(prop.getProperty("URL"));
		log.debug("Website launched");

	} // closing website

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Website closed");
	}

}
