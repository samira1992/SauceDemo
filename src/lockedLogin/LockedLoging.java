package lockedLogin;

import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LockedLoging {
	private WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LockedLoging locked = new LockedLoging();
		locked.setUp();
		locked.login("locked_out_user", "secret_sauce");
		String title = locked.getTitle();
		Assert.assertEquals(title, "Swag Labs", "Login Page title is incorrect");
		String errorMsg = locked.getErrorMsg();
		Assert.assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.",
				"Error message for locked out user is incorrect.");
		locked.tearDown();
	}
	public String getErrorMsg() {
		return driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
	}
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Dimension dim = new Dimension(150, 150);
		driver.manage().window().setSize(dim);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	public void login(String usernamep, String passwordp) {
		driver.findElement(By.id("user-name")).sendKeys(usernamep);
		driver.findElement(By.id("password")).sendKeys(passwordp);
		driver.findElement(By.className("btn_action")).click();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public String getTitle() {
		String title = driver.getTitle();
		System.out.println("Current title is" + title);
		return title;
	}
	

	public void tearDown() {
		driver.quit();
	}
}
