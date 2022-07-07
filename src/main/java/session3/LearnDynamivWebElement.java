package session3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnDynamivWebElement {

	WebDriver driver;

	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cnn.com/");

	}

	@Test
	public void XpathAxes() {
		// using CNN articles this xPath gives the first article on top left corner
		driver.findElement(By.xpath("//section[@id='homepage1-zone-1']/descendant::h3[1]")).click();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
