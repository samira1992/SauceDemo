package SauceLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
      System.setProperty("webdriver.chrome.driver","C:\\Users\\almira\\Desktop\\eclipse-workspace\\SauceDemo\\executable\\chromedriver.exe" );
      WebDriver driver = new ChromeDriver();
			
      //step 1: open sauce page
   
      //driver.get("https://www.saucedemo.com/");
      driver.navigate().to("https://www.saucedemo.com/");
      Thread.sleep(3000);
      WebElement username = driver.findElement(By.id("user-name"));
      
      WebElement password = driver.findElement(By.id("password"));
      
      WebElement logButton = driver.findElement(By.className("btn_action"));
      
      username.sendKeys("standard_user");
      Thread.sleep(3000);
      password.sendKeys("secret_sauce");
      Thread.sleep(3000);
      logButton.click();
      
      
      String currentUrl = driver.getCurrentUrl();
      if(currentUrl.contentEquals("https://www.saucedemo.com/inventory.html")) {
    	  System.out.println("User is on correct page.Test case:PASSED");
      }else {
    	  System.out.println("User is on wrong page.Test case:FAILED");
      }
      driver.quit();
	}

}
