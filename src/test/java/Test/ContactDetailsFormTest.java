package Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.LogOutPage;
import pageObjects.PackagesPage;
import pageObjects.PaymentDetails;
import pageObjects.packageDetailsPage;
import resources.Base;

public class ContactDetailsFormTest extends Base {
	public WebDriver driver;

	@Test
	public void ContactDetailsForm() throws IOException, InterruptedException {

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

		// Path to the Excel file
		String excelFilePath = "C:\\Users\\Relanto\\eclipse-workspace\\tripNow\\src\\main\\java\\resources\\LoginData.xlsx";

		// Open the Excel file
		FileInputStream fis = new FileInputStream(excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Iterate through each row in the Excel sheet
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			// Start from row 1, assuming row 0 is header
			Row row = sheet.getRow(i);
			String email = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			String firstName = row.getCell(2).getStringCellValue();
			String lastName = row.getCell(3).getStringCellValue();
			String emailInContactForm = row.getCell(4).getStringCellValue();
			double phoneNo = row.getCell(5).getNumericCellValue();
			String phoneNumberString = String.valueOf((long) phoneNo);
			double age = row.getCell(6).getNumericCellValue();
			String ageString = String.valueOf((long) age);
			String promoCode = row.getCell(7).getStringCellValue();

			// Entering email and password
			LogInPage.emailBox().clear();
			LogInPage.emailBox().sendKeys(email);
			log.debug("Email entered: " + email);

			LogInPage.passwordBox().clear();
			LogInPage.passwordBox().sendKeys(password);
			log.debug("Password entered: " + password);

			Thread.sleep(3000);
			LogInPage.SignIn().click();
			log.debug("Clicked on the Sign in button");
			log.debug("Testing contact details page");

			Thread.sleep(3000);
			String expectedBoookingURL = "http://localhost:4200/booking";
			String bookinURL = driver.getCurrentUrl();

			if (expectedBoookingURL.equalsIgnoreCase(bookinURL)) {
				log.debug("Log in is succesfull with :" + email + " " + password);

				// Entering first name
				PaymentDetails.firstName().clear();
				PaymentDetails.firstName().sendKeys(firstName);
				log.debug("First name enterd: " + firstName);

				// Entering last name
				PaymentDetails.lastName().clear();
				PaymentDetails.lastName().sendKeys(lastName);
				log.debug("Last name enterd: " + lastName);

				// Entering email and password
				PaymentDetails.emailBoxPayment().clear();
				PaymentDetails.emailBoxPayment().sendKeys(emailInContactForm);
				log.debug("Email entered: " + emailInContactForm);

				Thread.sleep(3000);
				// Entering Phone no
				PaymentDetails.phoneNumber().clear();
				PaymentDetails.phoneNumber().sendKeys(phoneNumberString);
				log.debug("Phone numbered enterd: " + phoneNumberString);

				Thread.sleep(3000);
				// Entering age
				PaymentDetails.age().clear();
				PaymentDetails.age().sendKeys(ageString);
				log.debug("Phone numbered enterd: " + ageString);

				Thread.sleep(3000);
				// Promo code box
				PaymentDetails.promoCodeBox().clear();
				PaymentDetails.promoCodeBox().sendKeys(promoCode);
				log.debug("Promo code is entered" + promoCode);
				Thread.sleep(5000);
				
				
				// clicking next button
				actions.moveToElement(PaymentDetails.nextBtn()).perform();
				PaymentDetails.nextBtn().click();
				log.debug("Clicked on the next button");
				Thread.sleep(5000);
			} else {
				log.debug("Log in is unsuccesfull with " + email + " " + password);

			}

		}

	}
	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(ContactDetailsFormTest.class.getName());
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
