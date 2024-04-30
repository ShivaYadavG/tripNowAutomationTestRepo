package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import resources.Base;

public class ExclusivePageTest extends Base {
	public WebDriver driver;

	@Test
	public void ExclusivePageTest() throws InterruptedException {

		// clicking on the packages link in nav bar
		LandingPage landingPage = new LandingPage(driver);
		landingPage.Exclusive().click();
		log.debug("Clicked on Exclusive page in nav bar");
		Thread.sleep(4000);
	}

	@BeforeMethod
	public void launching() throws IOException {

		log = LogManager.getLogger(ExclusivePageTest.class.getName());
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
