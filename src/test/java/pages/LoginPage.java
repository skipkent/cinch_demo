package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private static WebDriver driver;
	private WebDriverWait wait;
	
	private static By by_emailInput = By.cssSelector("#email_input");
	private static By by_passwordInput = By.cssSelector("#password_input");
	private static By by_loginButton = By.xpath("//button[text()='Log In']");
	
	public LoginPage(WebDriver aDriver) {
		this.driver = aDriver;
	}
	
	public LoginPage loginAs(String email, String password) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(by_emailInput));
		driver.findElement(by_emailInput).sendKeys(email);
		driver.findElement(by_passwordInput).sendKeys(password);
		driver.findElement(by_loginButton).click();
		return this;
	}

}
