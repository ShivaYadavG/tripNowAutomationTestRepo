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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactUsPage;
import resources.Base;

public class ContactUsPageTest extends Base {
	public WebDriver driver;

	@Test
	public void LogInTest() throws InterruptedException, EncryptedDocumentException, IOException {

		ContactUsPage ContactUsPage = new ContactUsPage(driver);

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
			String contactUsEmailBox = row.getCell(0).getStringCellValue();
			String contactUsName = row.getCell(2).getStringCellValue();
			double contactUsPhoneNo = row.getCell(5).getNumericCellValue();
			String contactUsPhoneNoString = String.valueOf((long) contactUsPhoneNo);

			Thread.sleep(3000);
			ContactUsPage.contactUsBtn().click();
			log.debug("Clikced on the contact us button");
			
			ContactUsPage.contactUsNameBox().sendKeys(contactUsName);
			log.debug("Entered name in contact us name box :" + contactUsName);

			
			ContactUsPage.contactUsEmailBox().sendKeys(contactUsEmailBox);
			log.debug("Entered email in contact us email box :" + contactUsEmailBox);

			ContactUsPage.contactUsPhoneNumber().sendKeys(contactUsPhoneNoString);
			log.debug("Entered phone number in contact us email box :" + contactUsPhoneNoString);
 
			ContactUsPage.contactUsQueryBox().sendKeys("Hello");
			log.debug("Entered query in the contact us query box");

			Thread.sleep(3000);
			ContactUsPage.contactUsSubmitBtn().click();
			log.debug("Clikced on the submit button in contact us form");
			Thread.sleep(3000);

		}

	}

	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(ContactUsPageTest.class.getName());

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
