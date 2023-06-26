package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl ="https://www.saucedemo.com/";
   @Before
   public void setUp(){
       openBrowser(baseUrl);

   }
   @Test
    public void userSholdLoginSuccessfullyWithValid(){
       //enter username
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       //enter password
     driver.findElement(By.id("password")).sendKeys("secret_sauce");
     //click login
     driver.findElement(By.xpath("//input[@id = 'login-button']")).click();
     //verify product text
     String expectedText ="Products";
     String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
       System.out.println(expectedText);
   }
   @Test
   public void verifyThatSixProductsAreDisplayedOnPage(){
       //enter username
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       //enter password
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
       //click on the login button
       driver.findElement(By.xpath("//input[@id = 'login-button']")).click();
       List<WebElement> elementlist = driver.findElements(By.className("inventory_item"));
       System.out.println("Total Product are " + elementlist.size());

   }
    @After
    public void tearDown() {
        closeBrowser();
        
    }
}
