package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAddToCartPage {

    WebDriver driver;
    By validateCart = By.cssSelector(".button-super[data-autom=proceed]");

    public ConfirmationAddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void openCartPage(){
        driver.findElement(validateCart).click();

    }
}
