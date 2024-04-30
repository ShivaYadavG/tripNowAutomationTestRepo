package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.LogOutPage;
import pageObjects.PackagesPage;
import pageObjects.PaymentDetails;
import pageObjects.packageDetailsPage;
import resources.Base;

public class LogOutTest extends Base {
	public WebDriver driver;


	@Test
	public void logOutTest() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

		System.out.println("Updating log out class directly from the git hub");
		System.out.println("Changes made in the log out class to push in to git hub");
		
		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.packages().click();
		log.debug("Clicked on packages in nav bar");

		Thread.sleep(2000);

		// clickig on the packages card
		PackagesPage packagesPage = new PackagesPage(driver);
		packagesPage.packageCard().click();
		log.debug("clicked on the packages card");

		// clicking on the reserve button
		packageDetailsPage packageDetailsPage = new packageDetailsPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(packageDetailsPage.reserveBtn()).perform();
		packageDetailsPage.reserveBtn().click();
		log.debug("clicked on the reserve button");

		// Scrolling up in log in page
		actions.sendKeys(Keys.PAGE_UP).build().perform();

		// entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		log.debug("Entered email : userone@gmail.com");
		
		LogInPage.passwordBox().sendKeys("userone@");
		log.debug("Entered email : userone@");

		actions.sendKeys(Keys.PAGE_UP).build().perform();
		
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		log.debug("Clicked on the sign in button");

		Thread.sleep(10000);
		// Clicking on log out icon
		LogOutPage.logInLogo().click();
		log.debug("Clicked on the log out logo");

		Thread.sleep(3000);
		
		
		LogOutPage.logOutButton().click();
		log.debug("clicked on the log out button");

		Thread.sleep(5000);
		
		LogOutPage.logInFormCloseBtn().click();
		Thread.sleep(3000);
		log.debug("clicked on the log ot button close button");

		}

	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(LogOutTest.class.getName());
		// opening the website
		driver = initializeBrowser();
		log.debug("Broswer initialized");

		// Passing Website URL
		driver.get(prop.getProperty("URL"));
		log.debug("Website launched");

	}

	// closing website
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Website closed");
	}
}
