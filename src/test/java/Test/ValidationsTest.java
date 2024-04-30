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

public class ValidationsTest extends Base {
	public WebDriver driver;


	@Test(priority = -1)
	public void packagesSearchBoxValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.packages().click();
		log.debug("Clicked on packages in nav bar");
		Thread.sleep(2000);

		PackagesPage PackagesPage = new PackagesPage(driver);
		PackagesPage.packageSearchBox().sendKeys("taj");
		//Log.debug("Searched for Taj in search box");
		Thread.sleep(3000);
		
	}
	
	@Test(priority = -2)
	public void packagesSearchBoxinValidValueValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.packages().click();
		log.debug("Clicked on packages in nav bar");
		Thread.sleep(2000);

		PackagesPage PackagesPage = new PackagesPage(driver);
		PackagesPage.packageSearchBox().sendKeys("111");
		log.debug("Entered invalid value in package search box");

		Thread.sleep(3000);
		
	}
	
	@Test(priority = 1)
	public void logInemailValidation() throws InterruptedException, EncryptedDocumentException, IOException {

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

		LogInPage LogInPage = new LogInPage(driver);
		LogInPage.emailBox().sendKeys("abcd");
		log.debug("Error message shown wehen invalid email entered : abcd");
		Thread.sleep(3000);
	}

	
	@Test(priority = 2)
	public void passwordValidation() throws InterruptedException, EncryptedDocumentException, IOException {

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

		LogInPage LogInPage = new LogInPage(driver);
		LogInPage.passwordBox().sendKeys("abcd");
		log.debug("Error message shown wehen invalid password entered : abcd");		Thread.sleep(3000);
	}
	
	// Contact details verification
	
	@Test(priority = 3)
	public void firstNameValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.firstName().sendKeys("shva1");
		log.debug("Error message shown wehen invalid first name entered : shiva1");		Thread.sleep(3000);
	
	}
	
	@Test(priority = 4)
	public void lastNameValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.lastName().sendKeys("shva1");
		log.debug("Error message shown wehen invalid last name entered : shiva1");
		Thread.sleep(3000);
	
	}
	
	@Test(priority = 5)
	public void emailValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.emailBoxPayment().sendKeys("abcd");
		log.debug("Error message shown wehen invalid email data entered : abcd.");		Thread.sleep(3000);
	
	}
	
	@Test(priority = 6)
	public void phoneNumberValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.phoneNumber().sendKeys("123");
		log.debug("Error message shown wehen invalid phone no. entered : 123");
		Thread.sleep(3000);
	
	}
	
	@Test(priority = 6)
	public void ageBelowLimitValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.age().sendKeys("14");
		log.debug("Error message shown wehen invalid age entered : 14");		Thread.sleep(3000);
	
	}
	
	@Test(priority = 6)
	public void ageAboveLimitValidation() throws InterruptedException, EncryptedDocumentException, IOException {

		PaymentDetails PaymentDetails = new PaymentDetails(driver);
		LogInPage LogInPage = new LogInPage(driver);
		LogOutPage LogOutPage = new LogOutPage(driver);

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
		
		//entering valid email and password for logging in
		LogInPage.emailBox().sendKeys("userone@gmail.com");
		LogInPage.passwordBox().sendKeys("userone@");
		Thread.sleep(3000);
		LogInPage.SignIn().click();
		
		// entering invalid first name
		PaymentDetails.age().sendKeys("101");
		log.debug("Error message shown wehen invalid age entered : 101");
		Thread.sleep(3000);
	
	}

	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(ValidationsTest.class.getName());
		// opening the website
		
		driver = initializeBrowser();
		log.debug("Broswer initialized");

		// Passing Website URL
		driver.get(prop.getProperty("URL"));
		log.debug("Website launched");

	}	// closing website
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Website closed");
	}
}
