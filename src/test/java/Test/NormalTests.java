package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalTests {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:4200/package-details/:id");
		driver.manage().window().maximize();
		
		WebElement calanderIcon = driver.findElement(By.xpath("/html/body/app-root/app-package-details/div/form/div[1]/div[2]/input"));
		Thread.sleep(2000);
		
		WebElement calander = calanderIcon.findElement(By.cssSelector("input[name='dot'] + .icon-calendar"));
		System.out.print("Clikced");
		Thread.sleep(2000);
		
		driver.close();
	}

}
