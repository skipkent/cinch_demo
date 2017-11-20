package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private final WebDriver driver;
	
	public HomePage(WebDriver aDriver) {
		this.driver = aDriver;
	}
	
	public static By by_loginButton = By.cssSelector(".login-menu-item");
	public static By by_slideOut = By.cssSelector(".slide-out");
	public static By by_blogNav = By.cssSelector(".blog-nav");
	
	public LoginPage goToLoginPage() throws Exception {
		Thread.sleep(3000);
		WebElement element = driver.findElement(by_blogNav);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(by_loginButton).click();
		return new LoginPage(driver);
	}
	
}
