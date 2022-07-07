package session3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginTest {
	WebDriver driver;

	@Before
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		// storing web element with WebElement

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement SIGNIN_BUTTON__ELEMENT = driver
				.findElement(By.xpath("//button[@class='btn btn-success block full-width' and @type='submit']"));
		

		// storing web element with By class
		By USER_NAME_FIELD = By.xpath("//*[@id='username']");
		By PASSWORD_FIELD = By.xpath("//*[@id='password']");
		By SIGNIN_BUTTON_FIELD = By.xpath("//button[@class='btn btn-success block full-width' and @type='submit']");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

		/*USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON__ELEMENT.click();*/

		Thread.sleep(2000);

		String userName = "demo@techfios.com";
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		boolean pageTitleDisplayStatus;

		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver
					.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
			pageTitleDisplayStatus = true;
		} catch (Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));

		Assert.assertTrue("page not found!!!", pageTitleDisplayStatus);

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
