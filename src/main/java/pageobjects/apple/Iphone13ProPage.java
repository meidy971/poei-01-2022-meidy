package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iphone13ProPage {

    WebDriver driver;
    By buyIphone13Pro = By.cssSelector(".ac-ln-action-button");

    public Iphone13ProPage(WebDriver driver){
        this.driver = driver;
    }

    public void buy(){
        driver.findElement(buyIphone13Pro).click();

    }
}
