package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.PackagesPage;
import resources.Base;

public class pacakagesPage extends Base {

	public WebDriver driver;

	@Test
	public void pacakagesPage() throws InterruptedException {

		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.packages().click();
		log.debug("Clicked on packages in nav bar");

		PackagesPage PackagesPage = new PackagesPage(driver);
		Thread.sleep(4000);
		Assert.assertTrue(PackagesPage.packageCard().isDisplayed());
		Thread.sleep(2000);

	}
	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(pacakagesPage.class.getName());
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
