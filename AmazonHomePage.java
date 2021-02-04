package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {

    private static WebElement element = null;

    public static WebElement testbox_search(WebDriver driver) {

        element= driver.findElement(By.id("twotabsearchtextbox"));
        return element;

    }

    public static WebElement button_search(WebDriver driver){
        element = driver.findElement(By.id("nav-search-submit-button"));
        return element;
    }

    public static WebElement search_result(WebDriver driver){
        element = driver.findElement(By.linkText("Unit Testing Principles, Practices, and Patterns: Effective testing styles, patterns, and reliable automation for unit testing, mocking, and integration testing with examples in C#"));
        return element;
    }

    public static WebElement expectedPrice(WebDriver driver){
        element = driver.findElement(By.id("newBuyBoxPrice"));
        return element;
    }

    public static WebElement click_add_cart(WebDriver driver){
        element = driver.findElement(By.id("add-to-cart-button"));
        return element;
    }

    public static WebElement expectedCartTotal(WebDriver driver){
        element = driver.findElement(By.xpath(
                "//*[@id='hlb-bottom-subcart']/.//span[contains(@class,'a-color-price hlb-price a-inline-block a-text-bold')]"));
        return element;
    }

    public static WebElement click_proceed_checkout(WebDriver driver){
        element = driver.findElement(By.id("hlb-ptc-btn-native-bottom"));
        return element;
    }

}
