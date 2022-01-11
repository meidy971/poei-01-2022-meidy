package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphone13ProPage {

    WebDriver driver;
    int timeout = 5;
    By chooseIphone13ProMax = By.cssSelector(".form-selector-input[data-autom=dimensionScreensize6_7inch] + label");
    By chooseIphone13ProMaxColor = By.cssSelector(".form-selector-input[data-autom=dimensionColorsierrablue] + label");
    By chooseIphone13ProMaxCapacity = By.cssSelector(".form-selector-input[data-autom=dimensionCapacity256gb] + label");
    By iphone13ProMaxNoTradeIn = By.cssSelector(".form-selector-input[data-autom=choose-noTradeIn] + label");
    By iphone13ProMaxToCart = By.cssSelector("[data-autom=add-to-cart]");
    By iphone13ProMaxNoAppleCare = By.cssSelector(".form-selector-input[data-autom=applecareplus_59_noapplecare] + label");




    public BuyIphone13ProPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectIphone13ProMax(){
        driver.findElement(chooseIphone13ProMax).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(chooseIphone13ProMaxColor));
    }
    public void selectBlueAlpin(){
        driver.findElement(chooseIphone13ProMaxColor).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(chooseIphone13ProMaxCapacity));
    }
    public void select256Go(){
        driver.findElement(chooseIphone13ProMaxCapacity).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(iphone13ProMaxNoTradeIn));
    }
    public void noAppleTradeIn(){
        driver.findElement(iphone13ProMaxNoTradeIn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(iphone13ProMaxNoAppleCare));
        wait.until(ExpectedConditions.elementToBeClickable(iphone13ProMaxToCart));
    }
    public void addToCart(){
        driver.findElement(iphone13ProMaxToCart).click();
    }
}
