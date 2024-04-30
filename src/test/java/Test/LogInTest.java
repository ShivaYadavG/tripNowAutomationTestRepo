package Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.LogOutPage;
import pageObjects.PackagesPage;
import pageObjects.packageDetailsPage;
import resources.Base;

public class LogInTest extends Base {
	public WebDriver driver;
	
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void LogInTest() throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		
		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.packages().click();
		log.debug("Clicked on packages in nav bar");
		Thread.sleep(2000);
		

		// clickig on the packages card
		PackagesPage packagesPage = new PackagesPage(driver);
		packagesPage.packageCard().click();
		log.debug("clicked on the package card");

		// clicking on the reserve button
		packageDetailsPage packageDetailsPage = new packageDetailsPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(packageDetailsPage.reserveBtn()).perform();
		packageDetailsPage.reserveBtn().click();
		log.debug("clicked on the reserve button");

		// Scrolling up in log in page
		actions.sendKeys(Keys.PAGE_UP).build().perform();

		LogInPage LogInPage = new LogInPage(driver);

		// Path to the Excel file
		String excelFilePath = "C:\\Users\\Relanto\\eclipse-workspace\\tripNow\\src\\main\\java\\resources\\LoginData.xlsx";

		// Open the Excel file
		FileInputStream fis = new FileInputStream(excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Iterate through each row in the Excel sheet
		for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
			// Start from row 1, assuming row 0 is header
			Row row = sheet.getRow(i);
			String email = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

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

			
			Thread.sleep(2000); 
			LogOutPage LogOutPage = new LogOutPage(driver);
			Thread.sleep(5000);
			
			if(LogOutPage.logOutButton().isDisplayed()) {
				log.debug("Log in is succesfull with :" + email + " "+ password);
				softAssert.assertTrue(true);
			}
			else {
				log.debug("Log in is unsuccesfull with " + email + " " + password);
				softAssert.fail("User credential wrong: " + email + " " + password);
		
			}
	
		}
	}



	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(LogInTest.class.getName());

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
