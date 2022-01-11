package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IphonePage {

    WebDriver driver;
    By selectIphone13Pro = By.cssSelector(".chapternav-item-iphone-13-pro");

    public IphonePage(WebDriver driver){
        this.driver = driver;
    }

    public void openIphone13ProPage(){
        driver.findElement(selectIphone13Pro).click();
    }
}
