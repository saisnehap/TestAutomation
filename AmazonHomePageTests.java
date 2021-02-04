package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

public class AmazonHomePageTests {

    private static WebDriver driver = null;

    public static void main(String[] args) {
        amazonSearch();
    }

    @Test
    public static void amazonSearch(){

        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromeDriver/chromedriver");
        driver =  new ChromeDriver();

        //Navigate to Amazon web page
        driver.get("https://www.amazon.com/");

        //Maximize current window
        driver.manage().window().maximize();

        //Search book name 'qa testing for beginners'
        AmazonHomePage.testbox_search(driver).sendKeys("qa testing for beginners");

        //Click on Search button
        AmazonHomePage.button_search(driver).sendKeys(Keys.RETURN);

        //Click on first search result
        AmazonHomePage.search_result(driver).sendKeys(Keys.RETURN);

        //Compare prices from search page to add to cart page
        String actualPrice = "$47.49";
        String expectedPrice = AmazonHomePage.expectedPrice(driver).getText();
        Assert.assertEquals(actualPrice,expectedPrice);

        //Click on add to cart
        AmazonHomePage.click_add_cart(driver).sendKeys(Keys.RETURN);

        //Compare prices from search page to proceed to checkout page
        String expectedCartPrice = AmazonHomePage.expectedCartTotal(driver).getText();
        Assert.assertEquals(actualPrice,expectedCartPrice);

        WebDriverWait wait = new WebDriverWait(driver,30);

        //click on proceed check out
        AmazonHomePage.click_proceed_checkout(driver).sendKeys(Keys.RETURN);

        //close the browser
        driver.quit();
    }

}
