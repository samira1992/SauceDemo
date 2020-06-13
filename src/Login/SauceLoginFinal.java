package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SauceLoginFinal {
	private WebDriver driver;
		public static void main(String[] args) {
			SauceLoginFinal userLog = new SauceLoginFinal();
			userLog.setUp();
			userLog.login("standard_user","secret_sauce");
	        String url = userLog.getUrl();
	        Assert.assertEquals(url,"https://www.saucedemo.com/inventory.html","Dashboard page url is incorrect");
	        userLog.tearDown();
		}
		public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executable\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://www.saucedemo.com/");
		}
		public void login(String usernamep, String passwordp) {
			driver.findElement(By.id("user-name")).sendKeys(usernamep);
			driver.findElement(By.id("password")).sendKeys(passwordp);
			driver.findElement(By.className("btn_action")).click();
		}
		public String getUrl() {
			String curUrl = driver.getCurrentUrl();
			System.out.println("Current url is" + " " + curUrl);
			return curUrl;
		}
		public void tearDown() {
			driver.quit();
		}
	}

