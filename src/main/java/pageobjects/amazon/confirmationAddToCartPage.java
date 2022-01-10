package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class confirmationAddToCartPage {

    WebDriver driver;
    By cartButtonSelector = By.id("nav-cart");

    public confirmationAddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void openCart(){
        driver.findElement(cartButtonSelector).click();
    }


}
