package test.login;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

public class LoginTest {
	
	private static WebDriver driver;
	private WebDriverWait wait;
	
	public static String url_production = "https://advisor.prd.cinchfinancial.com/login";
	public static String url_qa = "https://localhost/login";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/KWHome/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get(url_production);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void validLoginKent() throws Exception {
		LoginPage home = new LoginPage(driver);
		home.loginAs("username@email.com", "password!");
		wait = new WebDriverWait(driver, 5);
		// TODO: refactor this css into page object
		// TODO: refactor wait and other primal methods into BasePage object
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-page='app.dashboard.index']")));
		String actualText = driver.findElement(By.cssSelector(".cf-Box-Content")).getText();
		String expectedText = "The more you contribute to a rainy day fund the bigger the storm you can weather.";
		assertTrue("Text should contain as expected", actualText.contains(expectedText));;
	}

}
